package io.github.typesafegithub.workflows.domain

import io.github.typesafegithub.workflows.dsl.HasCustomArguments
import io.github.typesafegithub.workflows.validation.requireMatchesRegex
import kotlinx.serialization.Contextual

public data class Job<OUTPUT : JobOutputs>(
    val id: String,
    val name: String? = null,
    val runsOn: RunnerType,
    val steps: List<Step<*>>,
    val needs: List<Job<*>> = emptyList(),
    val outputs: OUTPUT,
    val env: Map<String, String> = mapOf(),
    val condition: String? = null,
    val strategyMatrix: Map<String, List<String>>? = null,
    val permissions: Map<Permission, Mode>? = null,
    val timeoutMinutes: Int? = null,
    val concurrency: Concurrency? = null,
    val container: Container? = null,
    val environment: Environment? = null,
    val services: Map<String, Container> = emptyMap(),
    override val _customArguments: Map<String, @Contextual Any?> = mapOf(),
) : HasCustomArguments {
    init {
        requireMatchesRegex(
            field = "Job.id",
            value = id,
            regex = Regex("[a-zA-Z_][a-zA-Z0-9_-]*"),
            url = "https://docs.github.com/en/actions/using-jobs/using-jobs-in-a-workflow#setting-an-id-for-a-job",
        )
        timeoutMinutes?.let { value ->
            require(value > 0) { "timeout should be positive" }
        }
        outputs.job = this
    }

    public inner class Result : AbstractResult("needs.$id.result")

    public val result: Result get() = Result()
}
