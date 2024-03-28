// This file was generated using action-binding-generator. Don't change it by hand, otherwise your
// changes will be overwritten with the next binding code regeneration.
// See https://github.com/typesafegithub/github-workflows-kt for more info.
@file:Suppress(
    "DataClassPrivateConstructor",
    "UNUSED_PARAMETER",
)

package io.github.typesafegithub.workflows.actions.softprops

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
 * Action: GH Release
 *
 * Github Action for creating Github Releases
 *
 * [Action on GitHub](https://github.com/softprops/action-gh-release)
 *
 * @param body Note-worthy description of changes in release
 * @param bodyPath Path to load note-worthy description of changes in release from
 * @param name Gives the release a custom name. Defaults to tag name
 * @param tagName Gives a tag name. Defaults to github.GITHUB_REF
 * @param draft Creates a draft release. Defaults to false
 * @param prerelease Identify the release as a prerelease. Defaults to false
 * @param files Newline-delimited list of path globs for asset files to upload
 * @param failOnUnmatchedFiles Fails if any of the `files` globs match nothing. Defaults to false
 * @param repository Repository to make releases against, in <owner>/<repo> format
 * @param token Authorized secret GitHub Personal Access Token. Defaults to github.token
 * @param targetCommitish Commitish value that determines where the Git tag is created from. Can be
 * any branch or commit SHA.
 * @param discussionCategoryName If specified, a discussion of the specified category is created and
 * linked to the release. The value must be a category that already exists in the repository. If there
 * is already a discussion linked to the release, this parameter is ignored.
 * @param generateReleaseNotes Whether to automatically generate the name and body for this release.
 * If name is specified, the specified name will be used; otherwise, a name will be automatically
 * generated. If body is specified, the body will be pre-pended to the automatically generated notes.
 * @param appendBody Append to existing body instead of overwriting it. Default is false.
 * @param makeLatest Specifies whether this release should be set as the latest release for the
 * repository. Drafts and prereleases cannot be set as latest. Can be `true`, `false`, or `legacy`.
 * Uses GitHub api default if not provided
 * @param _customInputs Type-unsafe map where you can put any inputs that are not yet supported by
 * the binding
 * @param _customVersion Allows overriding action's version, for example to use a specific minor
 * version, or a newer version that the binding doesn't yet know about
 */
public data class ActionGhReleaseV2 private constructor(
    /**
     * Note-worthy description of changes in release
     */
    public val body: String? = null,
    /**
     * Path to load note-worthy description of changes in release from
     */
    public val bodyPath: String? = null,
    /**
     * Gives the release a custom name. Defaults to tag name
     */
    public val name: String? = null,
    /**
     * Gives a tag name. Defaults to github.GITHUB_REF
     */
    public val tagName: String? = null,
    /**
     * Creates a draft release. Defaults to false
     */
    public val draft: Boolean? = null,
    /**
     * Identify the release as a prerelease. Defaults to false
     */
    public val prerelease: Boolean? = null,
    /**
     * Newline-delimited list of path globs for asset files to upload
     */
    public val files: List<String>? = null,
    /**
     * Fails if any of the `files` globs match nothing. Defaults to false
     */
    public val failOnUnmatchedFiles: Boolean? = null,
    /**
     * Repository to make releases against, in <owner>/<repo> format
     */
    public val repository: String? = null,
    /**
     * Authorized secret GitHub Personal Access Token. Defaults to github.token
     */
    public val token: String? = null,
    /**
     * Commitish value that determines where the Git tag is created from. Can be any branch or
     * commit SHA.
     */
    public val targetCommitish: String? = null,
    /**
     * If specified, a discussion of the specified category is created and linked to the release.
     * The value must be a category that already exists in the repository. If there is already a
     * discussion linked to the release, this parameter is ignored.
     */
    public val discussionCategoryName: String? = null,
    /**
     * Whether to automatically generate the name and body for this release. If name is specified,
     * the specified name will be used; otherwise, a name will be automatically generated. If body is
     * specified, the body will be pre-pended to the automatically generated notes.
     */
    public val generateReleaseNotes: Boolean? = null,
    /**
     * Append to existing body instead of overwriting it. Default is false.
     */
    public val appendBody: Boolean? = null,
    /**
     * Specifies whether this release should be set as the latest release for the repository. Drafts
     * and prereleases cannot be set as latest. Can be `true`, `false`, or `legacy`. Uses GitHub api
     * default if not provided
     */
    public val makeLatest: ActionGhReleaseV2.MakeLatest? = null,
    /**
     * Type-unsafe map where you can put any inputs that are not yet supported by the binding
     */
    public val _customInputs: Map<String, String> = mapOf(),
    /**
     * Allows overriding action's version, for example to use a specific minor version, or a newer
     * version that the binding doesn't yet know about
     */
    public val _customVersion: String? = null,
) : RegularAction<ActionGhReleaseV2.Outputs>("softprops", "action-gh-release", _customVersion ?:
        "v2") {
    public constructor(
        vararg pleaseUseNamedArguments: Unit,
        body: String? = null,
        bodyPath: String? = null,
        name: String? = null,
        tagName: String? = null,
        draft: Boolean? = null,
        prerelease: Boolean? = null,
        files: List<String>? = null,
        failOnUnmatchedFiles: Boolean? = null,
        repository: String? = null,
        token: String? = null,
        targetCommitish: String? = null,
        discussionCategoryName: String? = null,
        generateReleaseNotes: Boolean? = null,
        appendBody: Boolean? = null,
        makeLatest: ActionGhReleaseV2.MakeLatest? = null,
        _customInputs: Map<String, String> = mapOf(),
        _customVersion: String? = null,
    ) : this(body=body, bodyPath=bodyPath, name=name, tagName=tagName, draft=draft,
            prerelease=prerelease, files=files, failOnUnmatchedFiles=failOnUnmatchedFiles,
            repository=repository, token=token, targetCommitish=targetCommitish,
            discussionCategoryName=discussionCategoryName,
            generateReleaseNotes=generateReleaseNotes, appendBody=appendBody, makeLatest=makeLatest,
            _customInputs=_customInputs, _customVersion=_customVersion)

    @Suppress("SpreadOperator")
    override fun toYamlArguments(): LinkedHashMap<String, String> = linkedMapOf(
        *listOfNotNull(
            body?.let { "body" to it },
            bodyPath?.let { "body_path" to it },
            name?.let { "name" to it },
            tagName?.let { "tag_name" to it },
            draft?.let { "draft" to it.toString() },
            prerelease?.let { "prerelease" to it.toString() },
            files?.let { "files" to it.joinToString("\n") },
            failOnUnmatchedFiles?.let { "fail_on_unmatched_files" to it.toString() },
            repository?.let { "repository" to it },
            token?.let { "token" to it },
            targetCommitish?.let { "target_commitish" to it },
            discussionCategoryName?.let { "discussion_category_name" to it },
            generateReleaseNotes?.let { "generate_release_notes" to it.toString() },
            appendBody?.let { "append_body" to it.toString() },
            makeLatest?.let { "make_latest" to it.stringValue },
            *_customInputs.toList().toTypedArray(),
        ).toTypedArray()
    )

    override fun buildOutputObject(stepId: String): Outputs = Outputs(stepId)

    public sealed class MakeLatest(
        public val stringValue: String,
    ) {
        public object True : ActionGhReleaseV2.MakeLatest("true")

        public object False : ActionGhReleaseV2.MakeLatest("false")

        public object Legacy : ActionGhReleaseV2.MakeLatest("legacy")

        public class Custom(
            customStringValue: String,
        ) : ActionGhReleaseV2.MakeLatest(customStringValue)
    }

    public class Outputs(
        stepId: String,
    ) : Action.Outputs(stepId) {
        /**
         * URL to the Release HTML Page
         */
        public val url: String = "steps.$stepId.outputs.url"

        /**
         * Release ID
         */
        public val id: String = "steps.$stepId.outputs.id"

        /**
         * URL for uploading assets to the release
         */
        public val uploadUrl: String = "steps.$stepId.outputs.upload_url"

        /**
         * JSON array containing information about each uploaded asset, in the format given
         * [here](https://docs.github.com/en/rest/reference/repos#upload-a-release-asset--code-samples)
         * (minus the `uploader` field)
         */
        public val assets: String = "steps.$stepId.outputs.assets"
    }
}
