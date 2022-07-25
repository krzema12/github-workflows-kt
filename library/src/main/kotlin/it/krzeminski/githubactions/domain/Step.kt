package it.krzeminski.githubactions.domain

import it.krzeminski.githubactions.actions.Action
import it.krzeminski.githubactions.actions.ActionWithOutputs
import it.krzeminski.githubactions.dsl.HasCustomArguments
import kotlinx.serialization.Contextual

sealed class Step(
    open val id: String,
    open val env: LinkedHashMap<String, String> = linkedMapOf(),
    open val condition: String? = null,
    open val continueOnError: Boolean? = null,
    override val _customArguments: Map<String, @Contextual Any> = emptyMap(),
) : HasCustomArguments

interface WithOutputs<T> {
    val outputs: T
}

data class CommandStep(
    override val id: String,
    val name: String? = null,
    val command: String,
    override val env: LinkedHashMap<String, String> = linkedMapOf(),
    override val condition: String? = null,
    override val continueOnError: Boolean? = null,
    override val _customArguments: Map<String, @Contextual Any> = emptyMap(),
) : Step(
    id = id,
    condition = condition,
    continueOnError = continueOnError,
    env = env,
    _customArguments = _customArguments,
)

@Suppress("LongParameterList")
open class ExternalActionStep(
    override val id: String,
    open val name: String? = null,
    open val action: Action,
    override val env: LinkedHashMap<String, String> = linkedMapOf(),
    override val condition: String? = null,
    override val continueOnError: Boolean? = null,
    override val _customArguments: Map<String, @Contextual Any> = emptyMap(),
) : Step(
    id = id,
    condition = condition,
    continueOnError = continueOnError,
    env = env,
    _customArguments = _customArguments,
)

data class ExternalActionStepWithOutputs<T>(
    override val id: String,
    override val name: String? = null,
    override val action: ActionWithOutputs<T>,
    override val env: LinkedHashMap<String, String> = linkedMapOf(),
    override val condition: String? = null,
    override val continueOnError: Boolean? = null,
    override val outputs: T,
    override val _customArguments: Map<String, @Contextual Any> = emptyMap(),
) : ExternalActionStep(
    name = name,
    action = action,
    id = id,
    condition = condition,
    continueOnError = continueOnError,
    env = env,
    _customArguments = _customArguments,
),
    WithOutputs<T>
