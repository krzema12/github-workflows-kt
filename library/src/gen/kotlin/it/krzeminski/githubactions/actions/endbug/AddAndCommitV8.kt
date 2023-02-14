// This file was generated using 'wrapper-generator' module. Don't change it by hand, your changes will
// be overwritten with the next wrapper code regeneration. Instead, consider introducing changes to the
// generator itself.
@file:Suppress("DEPRECATION")

package it.krzeminski.githubactions.actions.endbug

import it.krzeminski.githubactions.domain.actions.Action
import it.krzeminski.githubactions.domain.actions.Action.Outputs
import java.util.LinkedHashMap
import kotlin.Deprecated
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.collections.toList
import kotlin.collections.toTypedArray

/**
 * Action: Add & Commit
 *
 * Automatically commit changes made in your workflow run directly to your repo
 *
 * [Action on GitHub](https://github.com/EndBug/add-and-commit)
 */
@Deprecated(
    message = "This action has a newer major version: AddAndCommitV9",
    replaceWith = ReplaceWith("AddAndCommitV9"),
)
public data class AddAndCommitV8(
    /**
     * Arguments for the git add command
     */
    public val add: String? = null,
    /**
     * The name of the user that will be displayed as the author of the commit
     */
    public val authorName: String? = null,
    /**
     * The email of the user that will be displayed as the author of the commit
     */
    public val authorEmail: String? = null,
    /**
     * Additional arguments for the git commit command
     */
    public val commit: String? = null,
    /**
     * The name of the custom committer you want to use
     */
    public val committerName: String? = null,
    /**
     * The email of the custom committer you want to use
     */
    public val committerEmail: String? = null,
    /**
     * The directory where your repository is located. You should use actions/checkout first to set
     * it up
     */
    public val cwd: String? = null,
    /**
     * How the action should fill missing author name or email.
     */
    public val defaultAuthor: AddAndCommitV8.DefaultAuthor? = null,
    /**
     * The message for the commit
     */
    public val message: String? = null,
    /**
     * The name of the branch to create.
     */
    public val newBranch: String? = null,
    /**
     * The way the action should handle pathspec errors from the add and remove commands.
     */
    public val pathspecErrorHandling: AddAndCommitV8.PathspecErrorHandling? = null,
    /**
     * Arguments for the git pull command. By default, the action does not pull.
     */
    public val pull: String? = null,
    /**
     * Whether to push the commit and, if any, its tags to the repo. It can also be used to set the
     * git push arguments (more info in the README)
     */
    public val push: String? = null,
    /**
     * Arguments for the git rm command
     */
    public val remove: String? = null,
    /**
     * Arguments for the git tag command (the tag name always needs to be the first word not
     * preceded by a hyphen)
     */
    public val tag: String? = null,
    /**
     * The token used to make requests to the GitHub API. It's NOT used to make commits and should
     * not be changed.
     */
    public val githubToken: String? = null,
    /**
     * Type-unsafe map where you can put any inputs that are not yet supported by the wrapper
     */
    public val _customInputs: Map<String, String> = mapOf(),
    /**
     * Allows overriding action's version, for example to use a specific minor version, or a newer
     * version that the wrapper doesn't yet know about
     */
    public val _customVersion: String? = null,
) : Action<AddAndCommitV8.Outputs>("EndBug", "add-and-commit", _customVersion ?: "v8") {
    @Suppress("SpreadOperator")
    public override fun toYamlArguments(): LinkedHashMap<String, String> = linkedMapOf(
        *listOfNotNull(
            add?.let { "add" to it },
            authorName?.let { "author_name" to it },
            authorEmail?.let { "author_email" to it },
            commit?.let { "commit" to it },
            committerName?.let { "committer_name" to it },
            committerEmail?.let { "committer_email" to it },
            cwd?.let { "cwd" to it },
            defaultAuthor?.let { "default_author" to it.stringValue },
            message?.let { "message" to it },
            newBranch?.let { "new_branch" to it },
            pathspecErrorHandling?.let { "pathspec_error_handling" to it.stringValue },
            pull?.let { "pull" to it },
            push?.let { "push" to it },
            remove?.let { "remove" to it },
            tag?.let { "tag" to it },
            githubToken?.let { "github_token" to it },
            *_customInputs.toList().toTypedArray(),
        ).toTypedArray()
    )

    public override fun buildOutputObject(stepId: String): Outputs = Outputs(stepId)

    public sealed class DefaultAuthor(
        public val stringValue: String,
    ) {
        public object GithubActor : AddAndCommitV8.DefaultAuthor("github_actor")

        public object UserInfo : AddAndCommitV8.DefaultAuthor("user_info")

        public object GithubActions : AddAndCommitV8.DefaultAuthor("github_actions")

        public class Custom(
            customStringValue: String,
        ) : AddAndCommitV8.DefaultAuthor(customStringValue)
    }

    public sealed class PathspecErrorHandling(
        public val stringValue: String,
    ) {
        public object Ignore : AddAndCommitV8.PathspecErrorHandling("ignore")

        public object ExitImmediately : AddAndCommitV8.PathspecErrorHandling("exitImmediately")

        public object ExitAtEnd : AddAndCommitV8.PathspecErrorHandling("exitAtEnd")

        public class Custom(
            customStringValue: String,
        ) : AddAndCommitV8.PathspecErrorHandling(customStringValue)
    }

    public class Outputs(
        stepId: String,
    ) : Action.Outputs(stepId) {
        /**
         * Whether the action has created a commit.
         */
        public val committed: String = "steps.$stepId.outputs.committed"

        /**
         * The complete SHA of the commit that has been created.
         */
        public val commitLongSha: String = "steps.$stepId.outputs.commit_long_sha"

        /**
         * The short SHA of the commit that has been created.
         */
        public val commitSha: String = "steps.$stepId.outputs.commit_sha"

        /**
         * Whether the action has pushed to the remote.
         */
        public val pushed: String = "steps.$stepId.outputs.pushed"

        /**
         * Whether the action has created a tag.
         */
        public val tagged: String = "steps.$stepId.outputs.tagged"
    }
}
