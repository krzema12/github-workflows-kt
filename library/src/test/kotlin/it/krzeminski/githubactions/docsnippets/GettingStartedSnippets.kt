package it.krzeminski.githubactions.docsnippets

/* ktlint-disable import-ordering */
import io.kotest.core.spec.style.FunSpec
// --8<-- [start:gettingStarted2]
import it.krzeminski.githubactions.actions.actions.CheckoutV3
import it.krzeminski.githubactions.domain.RunnerType.UbuntuLatest
import it.krzeminski.githubactions.domain.triggers.Push
import it.krzeminski.githubactions.dsl.workflow
import it.krzeminski.githubactions.yaml.toYaml
// --8<-- [end:gettingStarted2]
import java.io.File
/* ktlint-enable import-ordering */

class GettingStartedSnippets : FunSpec({
    test("gettingStarted") {
/* ktlint-disable indent */
/*
// --8<-- [start:gettingStarted1]
#!/usr/bin/env kotlin

@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.38.0")

// --8<-- [end:gettingStarted1]
*/
@Suppress("VariableNaming")
val __FILE__ = File("")
// --8<-- [start:gettingStarted3]

val workflow = workflow(
    name = "Test workflow",
    on = listOf(Push()),
    sourceFile = __FILE__.toPath(),
) {
    job(id = "test_job", runsOn = UbuntuLatest) {
        uses(name = "Check out", action = CheckoutV3())
        run(name = "Print greeting", command = "echo 'Hello world!'")
    }
}

println(workflow.toYaml())
// --8<-- [end:gettingStarted3]
/* ktlint-enable indent */
    }
},)
