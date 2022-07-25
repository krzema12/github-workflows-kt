package it.krzeminski.githubactions.domain.triggers

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import it.krzeminski.githubactions.yaml.triggersToYaml

class OtherTriggersTest : FunSpec({

    test("Creating all triggers without any argument") {
        val triggers: List<Trigger> = listOf(
            BranchProtectionRule(),
            CheckRun(),
            CheckSuite(),
            Create(),
            Delete(),
            Deployment(),
            DeploymentStatus(),
            Discussion(),
            DiscussionComment(),
            Fork(),
            Gollum(),
            IssueComment(),
            Issues(),
            Label(),
            Milestone(),
            PageBuild(),
            Project(),
            ProjectCard(),
            ProjectColumn(),
            PublicWorkflow(),
            PullRequest(),
            PullRequestReview(),
            PullRequestReviewComment(),
            PullRequestTarget(),
            Push(),
            RegistryPackage(),
            Release(),
            RepositoryDispatch(),
            Schedule(emptyList()),
            Status(),
            Watch(),
            WorkflowCall(),
            WorkflowDispatch(),
            WorkflowRun(),
        )

        triggers.triggersToYaml() shouldBe """
            branch_protection_rule:
            check_run:
            check_suite:
            create:
            delete:
            deployment:
            deployment_status:
            discussion:
            discussion_comment:
            fork:
            gollum:
            issue_comment:
            issues:
            label:
            milestone:
            page_build:
            project:
            project_card:
            project_column:
            public:
            pull_request:
            pull_request_review:
            pull_request_review_comment:
            pull_request_target:
            push:
            registry_package:
            release:
            repository_dispatch:
            schedule:
            status:
            watch:
            workflow_call:
            workflow_dispatch:
            workflow_run:
        """.trimIndent()
    }

    test("Creating all triggers with free arguments") {
        fun types(vararg types: String) = mapOf(
            "types" to types.toList()
        )

        val triggers: List<Trigger> = listOf(
            BranchProtectionRule(types("created", "deleted")),
            CheckRun(types("completed", "rerequested")),
            CheckSuite(),
            Create(),
            Delete(),
            Deployment(),
            DeploymentStatus(),
            Discussion(types("created", "edited", "answered")),
            DiscussionComment(),
            Fork(),
            Gollum(),
            IssueComment(types("created", "edited", "deleted")),
            Issues(types("opened", "edited")),
            Label(types("commented", "deleted", "edited")),
            Milestone(types("created", "closed")),
            PageBuild(),
            Project(types("created", "deleted")),
            ProjectCard(types("created", "moved")),
            ProjectColumn(types("moved")),
            PublicWorkflow(),
            PullRequest(),
            PullRequestReview(),
            PullRequestReviewComment(types("created", "edited")),
            PullRequestTarget(),
            Push(),
            RegistryPackage(types("published", "updated")),
            Release(types("published", "unpublished")),
            RepositoryDispatch(),
            Schedule(emptyList()),
            Status(types("started")),
            Watch(),
            WorkflowCall(),
            WorkflowDispatch(),
            WorkflowRun(types("completed", "requested")),
        )

        triggers.triggersToYaml() shouldBe """
            branch_protection_rule:
              types:
              - created
              - deleted
            check_run:
              types:
              - completed
              - rerequested
            check_suite:
            create:
            delete:
            deployment:
            deployment_status:
            discussion:
              types:
              - created
              - edited
              - answered
            discussion_comment:
            fork:
            gollum:
            issue_comment:
              types:
              - created
              - edited
              - deleted
            issues:
              types:
              - opened
              - edited
            label:
              types:
              - commented
              - deleted
              - edited
            milestone:
              types:
              - created
              - closed
            page_build:
            project:
              types:
              - created
              - deleted
            project_card:
              types:
              - created
              - moved
            project_column:
              types:
              - moved
            public:
            pull_request:
            pull_request_review:
            pull_request_review_comment:
              types:
              - created
              - edited
            pull_request_target:
            push:
            registry_package:
              types:
              - published
              - updated
            release:
              types:
              - published
              - unpublished
            repository_dispatch:
            schedule:
            status:
              types:
              - started
            watch:
            workflow_call:
            workflow_dispatch:
            workflow_run:
              types:
              - completed
              - requested
        """.trimIndent()
    }
})
