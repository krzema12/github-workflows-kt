// This file was generated using action-binding-generator. Don't change it by hand, otherwise your
// changes will be overwritten with the next binding code regeneration.
// See https://github.com/typesafegithub/github-workflows-kt for more info.
@file:Suppress(
    "DataClassPrivateConstructor",
    "UNUSED_PARAMETER",
)

package io.github.typesafegithub.workflows.actions.peterevans

import io.github.typesafegithub.workflows.domain.actions.Action
import io.github.typesafegithub.workflows.domain.actions.RegularAction
import java.util.LinkedHashMap
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.toList
import kotlin.collections.toTypedArray

/**
 * Action: Create Pull Request
 *
 * Creates a pull request for changes to your repository in the actions workspace
 *
 * [Action on GitHub](https://github.com/peter-evans/create-pull-request)
 *
 * @param token GITHUB_TOKEN or a `repo` scoped Personal Access Token (PAT)
 * @param gitToken The Personal Access Token (PAT) that the action will use for git operations.
 * Defaults to the value of `token`.
 * @param path Relative path under $GITHUB_WORKSPACE to the repository. Defaults to
 * $GITHUB_WORKSPACE.
 * @param addPaths A comma or newline-separated list of file paths to commit. Paths should follow
 * git's pathspec syntax. Defaults to adding all new and modified files.
 * @param commitMessage The message to use when committing changes.
 * @param committer The committer name and email address in the format `Display Name
 * <email@address.com>`. Defaults to the GitHub Actions bot user.
 * @param author The author name and email address in the format `Display Name <email@address.com>`.
 * Defaults to the user who triggered the workflow run.
 * @param signoff Add `Signed-off-by` line by the committer at the end of the commit log message.
 * @param branch The pull request branch name.
 * @param deleteBranch Delete the `branch` if it doesn't have an active pull request associated with
 * it.
 * @param branchSuffix The branch suffix type when using the alternative branching strategy.
 * @param base The pull request base branch. Defaults to the branch checked out in the workflow.
 * @param pushToFork A fork of the checked out parent repository to which the pull request branch
 * will be pushed. e.g. `owner/repo-fork`. The pull request will be created to merge the fork's branch
 * into the parent's base.
 * @param title The title of the pull request.
 * @param body The body of the pull request.
 * @param bodyPath The path to a file containing the pull request body. Takes precedence over
 * `body`.
 * @param labels A comma or newline separated list of labels.
 * @param assignees A comma or newline separated list of assignees (GitHub usernames).
 * @param reviewers A comma or newline separated list of reviewers (GitHub usernames) to request a
 * review from.
 * @param teamReviewers A comma or newline separated list of GitHub teams to request a review from.
 * Note that a `repo` scoped Personal Access Token (PAT) may be required.
 * @param milestone The number of the milestone to associate the pull request with.
 * @param draft Create a draft pull request. It is not possible to change draft status after
 * creation except through the web interface
 * @param _customInputs Type-unsafe map where you can put any inputs that are not yet supported by
 * the binding
 * @param _customVersion Allows overriding action's version, for example to use a specific minor
 * version, or a newer version that the binding doesn't yet know about
 */
public data class CreatePullRequestV6 private constructor(
    /**
     * GITHUB_TOKEN or a `repo` scoped Personal Access Token (PAT)
     */
    public val token: String? = null,
    /**
     * The Personal Access Token (PAT) that the action will use for git operations. Defaults to the
     * value of `token`.
     */
    public val gitToken: String? = null,
    /**
     * Relative path under $GITHUB_WORKSPACE to the repository. Defaults to $GITHUB_WORKSPACE.
     */
    public val path: String? = null,
    /**
     * A comma or newline-separated list of file paths to commit. Paths should follow git's pathspec
     * syntax. Defaults to adding all new and modified files.
     */
    public val addPaths: List<String>? = null,
    /**
     * The message to use when committing changes.
     */
    public val commitMessage: String? = null,
    /**
     * The committer name and email address in the format `Display Name <email@address.com>`.
     * Defaults to the GitHub Actions bot user.
     */
    public val committer: String? = null,
    /**
     * The author name and email address in the format `Display Name <email@address.com>`. Defaults
     * to the user who triggered the workflow run.
     */
    public val author: String? = null,
    /**
     * Add `Signed-off-by` line by the committer at the end of the commit log message.
     */
    public val signoff: Boolean? = null,
    /**
     * The pull request branch name.
     */
    public val branch: String? = null,
    /**
     * Delete the `branch` if it doesn't have an active pull request associated with it.
     */
    public val deleteBranch: Boolean? = null,
    /**
     * The branch suffix type when using the alternative branching strategy.
     */
    public val branchSuffix: String? = null,
    /**
     * The pull request base branch. Defaults to the branch checked out in the workflow.
     */
    public val base: String? = null,
    /**
     * A fork of the checked out parent repository to which the pull request branch will be pushed.
     * e.g. `owner/repo-fork`. The pull request will be created to merge the fork's branch into the
     * parent's base.
     */
    public val pushToFork: String? = null,
    /**
     * The title of the pull request.
     */
    public val title: String? = null,
    /**
     * The body of the pull request.
     */
    public val body: String? = null,
    /**
     * The path to a file containing the pull request body. Takes precedence over `body`.
     */
    public val bodyPath: String? = null,
    /**
     * A comma or newline separated list of labels.
     */
    public val labels: List<String>? = null,
    /**
     * A comma or newline separated list of assignees (GitHub usernames).
     */
    public val assignees: List<String>? = null,
    /**
     * A comma or newline separated list of reviewers (GitHub usernames) to request a review from.
     */
    public val reviewers: List<String>? = null,
    /**
     * A comma or newline separated list of GitHub teams to request a review from. Note that a
     * `repo` scoped Personal Access Token (PAT) may be required.
     */
    public val teamReviewers: List<String>? = null,
    /**
     * The number of the milestone to associate the pull request with.
     */
    public val milestone: String? = null,
    /**
     * Create a draft pull request. It is not possible to change draft status after creation except
     * through the web interface
     */
    public val draft: Boolean? = null,
    /**
     * Type-unsafe map where you can put any inputs that are not yet supported by the binding
     */
    public val _customInputs: Map<String, String> = mapOf(),
    /**
     * Allows overriding action's version, for example to use a specific minor version, or a newer
     * version that the binding doesn't yet know about
     */
    public val _customVersion: String? = null,
) : RegularAction<CreatePullRequestV6.Outputs>("peter-evans", "create-pull-request", _customVersion
        ?: "v6") {
    public constructor(
        vararg pleaseUseNamedArguments: Unit,
        token: String? = null,
        gitToken: String? = null,
        path: String? = null,
        addPaths: List<String>? = null,
        commitMessage: String? = null,
        committer: String? = null,
        author: String? = null,
        signoff: Boolean? = null,
        branch: String? = null,
        deleteBranch: Boolean? = null,
        branchSuffix: String? = null,
        base: String? = null,
        pushToFork: String? = null,
        title: String? = null,
        body: String? = null,
        bodyPath: String? = null,
        labels: List<String>? = null,
        assignees: List<String>? = null,
        reviewers: List<String>? = null,
        teamReviewers: List<String>? = null,
        milestone: String? = null,
        draft: Boolean? = null,
        _customInputs: Map<String, String> = mapOf(),
        _customVersion: String? = null,
    ) : this(token=token, gitToken=gitToken, path=path, addPaths=addPaths,
            commitMessage=commitMessage, committer=committer, author=author, signoff=signoff,
            branch=branch, deleteBranch=deleteBranch, branchSuffix=branchSuffix, base=base,
            pushToFork=pushToFork, title=title, body=body, bodyPath=bodyPath, labels=labels,
            assignees=assignees, reviewers=reviewers, teamReviewers=teamReviewers,
            milestone=milestone, draft=draft, _customInputs=_customInputs,
            _customVersion=_customVersion)

    @Suppress("SpreadOperator")
    override fun toYamlArguments(): LinkedHashMap<String, String> = linkedMapOf(
        *listOfNotNull(
            token?.let { "token" to it },
            gitToken?.let { "git-token" to it },
            path?.let { "path" to it },
            addPaths?.let { "add-paths" to it.joinToString("\n") },
            commitMessage?.let { "commit-message" to it },
            committer?.let { "committer" to it },
            author?.let { "author" to it },
            signoff?.let { "signoff" to it.toString() },
            branch?.let { "branch" to it },
            deleteBranch?.let { "delete-branch" to it.toString() },
            branchSuffix?.let { "branch-suffix" to it },
            base?.let { "base" to it },
            pushToFork?.let { "push-to-fork" to it },
            title?.let { "title" to it },
            body?.let { "body" to it },
            bodyPath?.let { "body-path" to it },
            labels?.let { "labels" to it.joinToString("\n") },
            assignees?.let { "assignees" to it.joinToString("\n") },
            reviewers?.let { "reviewers" to it.joinToString("\n") },
            teamReviewers?.let { "team-reviewers" to it.joinToString("\n") },
            milestone?.let { "milestone" to it },
            draft?.let { "draft" to it.toString() },
            *_customInputs.toList().toTypedArray(),
        ).toTypedArray()
    )

    override fun buildOutputObject(stepId: String): Outputs = Outputs(stepId)

    public class Outputs(
        stepId: String,
    ) : Action.Outputs(stepId) {
        /**
         * The pull request number
         */
        public val pullRequestNumber: String = "steps.$stepId.outputs.pull-request-number"

        /**
         * The URL of the pull request.
         */
        public val pullRequestUrl: String = "steps.$stepId.outputs.pull-request-url"

        /**
         * The pull request operation performed by the action, `created`, `updated` or `closed`.
         */
        public val pullRequestOperation: String = "steps.$stepId.outputs.pull-request-operation"

        /**
         * The commit SHA of the pull request branch.
         */
        public val pullRequestHeadSha: String = "steps.$stepId.outputs.pull-request-head-sha"

        /**
         * The pull request branch name
         */
        public val pullRequestBranch: String = "steps.$stepId.outputs.pull-request-branch"
    }
}
