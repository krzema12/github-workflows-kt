package generated

import it.krzeminski.githubactions.actions.actions.CheckoutV3
import it.krzeminski.githubactions.actions.actions.SetupJavaV3
import it.krzeminski.githubactions.actions.docker.SetupBuildxActionV2
import it.krzeminski.githubactions.actions.gradle.GradleBuildActionV2
import it.krzeminski.githubactions.domain.RunnerType
import it.krzeminski.githubactions.domain.Workflow
import it.krzeminski.githubactions.domain.triggers.Cron
import it.krzeminski.githubactions.domain.triggers.PullRequest
import it.krzeminski.githubactions.domain.triggers.PullRequestTarget
import it.krzeminski.githubactions.domain.triggers.Push
import it.krzeminski.githubactions.domain.triggers.Schedule
import it.krzeminski.githubactions.domain.triggers.WorkflowDispatch
import it.krzeminski.githubactions.domain.triggers.WorkflowDispatch.Type.Choice
import it.krzeminski.githubactions.dsl.expressions.expr
import it.krzeminski.githubactions.dsl.workflow
import java.nio.`file`.Paths
import kotlin.collections.linkedMapOf
import kotlin.collections.listOf
import kotlin.collections.mapOf

public val workflowGenerated: Workflow = workflow(
      name = "generated",
      on = listOf(
        PullRequest(
          types = listOf(PullRequest.Type.AutoMergeDisabled, PullRequest.Type.Opened),
          branches = listOf("branch1", "branch2"),
          paths = listOf("path1", "path2"),
        ),
        Push(
          branches = listOf("branch1", "branch2"),
          tags = listOf("tag1", "tag2"),
          paths = listOf("path1", "path2"),
        ),
        PullRequestTarget(),
        Schedule(listOf(
          Cron("0 0 * * *"),
        )),
        WorkflowDispatch(mapOf(
          "logLevel" to WorkflowDispatch.Input(
            type = Choice,
            description = "Log level",
            default = "warning",
            required = true,
            options = listOf("info", "warning", "debug"),
          ),
        ))
        ),
      sourceFile = Paths.get(".github/workflows/generated.main.kts"),
      env = linkedMapOf(
        "GRADLE_ENTERPRISE_ACCESS_KEY" to expr("secrets.GRADLE_ENTERPRISE_ACCESS_KEY"),
        "GRADLE_BUILD_ACTION_CACHE_DEBUG_ENABLED" to "true",
      ),
    ) {
      job(
        id = "check_yaml_consistency",
        runsOn = RunnerType.UbuntuLatest,
      ) {
        uses(
          name = "Check out",
          action = CheckoutV3(),
        )
        run(
          name = "Install Kotlin",
          command = "sudo snap install --classic kotlin",
        )
        run(
          name = "Consistency check",
          command = "diff -u '.github/workflows/build.yaml' <('.github/workflows/build.main.kts')",
          env = linkedMapOf(
            "HELLO" to "ok",
            "PAT" to "rick",
          ),
          condition = "true",
        )
      }

      job(
        id = "build_for_UbuntuLatest",
        runsOn = RunnerType.UbuntuLatest,
        env = linkedMapOf(
          "COLOR" to "blue",
          "SIZE" to "XXL",
        ),

        _customArguments = mapOf(
        "needs" to listOf("check_yaml_consistency"),
        )
      ) {
        uses(
          name = "Checkout",
          action = CheckoutV3(),
          env = linkedMapOf(
            "HELLO" to "ok",
            "PAT" to "rick",
          ),
        )
        uses(
          name = "Set up JDK",
          action = SetupJavaV3(
            javaVersion = "11",
            distribution = SetupJavaV3.Distribution.Adopt,
          ),
          env = linkedMapOf(
            "HELLO" to "ok",
            "PAT" to "rick",
          ),
        )
        uses(
          name = "Build",
          action = GradleBuildActionV2(
            arguments = "build",
          ),
        )
        uses(
          name = "setup",
          action = SetupBuildxActionV2(
            driverOpts = listOf(
              "hello",
              "world",
            )
            ,
            install = true,
          ),
        )
      }

    }
