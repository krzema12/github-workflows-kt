#!/usr/bin/env kotlin
@file:Repository("https://repo1.maven.org/maven2/")
@file:DependsOn("io.github.typesafegithub:github-workflows-kt:1.14.0")

@file:Repository("https://github-workflows-kt-bindings.colman.com.br/binding/")
@file:DependsOn("actions:checkout:v4")
@file:DependsOn("gradle:actions__setup-gradle:v3")

@file:Import("_shared.main.kts")
@file:Import("setup-java.main.kts")

import io.github.typesafegithub.workflows.actions.actions.Checkout
import io.github.typesafegithub.workflows.actions.gradle.ActionsSetupGradle
import io.github.typesafegithub.workflows.domain.RunnerType.UbuntuLatest
import io.github.typesafegithub.workflows.domain.triggers.Cron
import io.github.typesafegithub.workflows.domain.triggers.Schedule
import io.github.typesafegithub.workflows.domain.triggers.WorkflowDispatch
import io.github.typesafegithub.workflows.dsl.expressions.expr
import io.github.typesafegithub.workflows.dsl.workflow
import io.github.typesafegithub.workflows.yaml.writeToFile

workflow(
    name = "Create action update PRs",
    on = listOf(
        Schedule(listOf(
            Cron(dayWeek = "4", hour = "7", minute = "0")
        )),
        WorkflowDispatch(),
    ),
    sourceFile = __FILE__.toPath(),
    yamlConsistencyJobCondition = disableScheduledJobInForks,
) {
    job(
        id = "check-updates-and-create-prs",
        runsOn = UbuntuLatest,
        condition = disableScheduledJobInForks,
    ) {
        uses(action = Checkout())
        setupJava()
        uses(action = ActionsSetupGradle())
        run(
            name = "Run logic",
            env = linkedMapOf("GITHUB_TOKEN" to expr("secrets.GITHUB_TOKEN")),
            command = "./gradlew createActionUpdatePRs",
        )
    }
}.writeToFile()
