// This file was generated using action-binding-generator. Don't change it by hand, otherwise your
// changes will be overwritten with the next binding code regeneration.
// See https://github.com/typesafegithub/github-workflows-kt for more info.
@file:Suppress(
    "DataClassPrivateConstructor",
    "UNUSED_PARAMETER",
)

package io.github.typesafegithub.workflows.actions.actions

import io.github.typesafegithub.workflows.domain.actions.Action
import io.github.typesafegithub.workflows.domain.actions.RegularAction
import java.util.LinkedHashMap
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.Map
import kotlin.collections.toList
import kotlin.collections.toTypedArray

/**
 * Action: Checkout
 *
 * Checkout a Git repository at a particular version
 *
 * [Action on GitHub](https://github.com/actions/checkout)
 *
 * @param repository Repository name with owner. For example, actions/checkout
 * @param ref The branch, tag or SHA to checkout. When checking out the repository that triggered a
 * workflow, this defaults to the reference or SHA for that event.  Otherwise, uses the default branch.
 * @param token Personal access token (PAT) used to fetch the repository. The PAT is configured with
 * the local git config, which enables your scripts to run authenticated git commands. The post-job
 * step removes the PAT.
 *
 * We recommend using a service account with the least permissions necessary. Also when generating a
 * new PAT, select the least scopes necessary.
 *
 * [Learn more about creating and using encrypted
 * secrets](https://help.github.com/en/actions/automating-your-workflow-with-github-actions/creating-and-using-encrypted-secrets)
 * @param sshKey SSH key used to fetch the repository. The SSH key is configured with the local git
 * config, which enables your scripts to run authenticated git commands. The post-job step removes the
 * SSH key.
 *
 * We recommend using a service account with the least permissions necessary.
 *
 * [Learn more about creating and using encrypted
 * secrets](https://help.github.com/en/actions/automating-your-workflow-with-github-actions/creating-and-using-encrypted-secrets)
 * @param sshKnownHosts Known hosts in addition to the user and global host key database. The public
 * SSH keys for a host may be obtained using the utility `ssh-keyscan`. For example, `ssh-keyscan
 * github.com`. The public key for github.com is always implicitly added.
 * @param sshStrict Whether to perform strict host key checking. When true, adds the options
 * `StrictHostKeyChecking=yes` and `CheckHostIP=no` to the SSH command line. Use the input
 * `ssh-known-hosts` to configure additional hosts.
 * @param sshUser The user to use when connecting to the remote SSH host. By default 'git' is used.
 * @param persistCredentials Whether to configure the token or SSH key with the local git config
 * @param path Relative path under $GITHUB_WORKSPACE to place the repository
 * @param clean Whether to execute `git clean -ffdx && git reset --hard HEAD` before fetching
 * @param filter Partially clone against a given filter. Overrides sparse-checkout if set.
 * @param sparseCheckout Do a sparse checkout on given patterns. Each pattern should be separated
 * with new lines.
 * @param sparseCheckoutConeMode Specifies whether to use cone-mode when doing a sparse checkout.
 * @param fetchDepth Number of commits to fetch. 0 indicates all history for all branches and tags.
 * @param fetchTags Whether to fetch tags, even if fetch-depth > 0.
 * @param showProgress Whether to show progress status output when fetching.
 * @param lfs Whether to download Git-LFS files
 * @param submodules Whether to checkout submodules: `true` to checkout submodules or `recursive` to
 * recursively checkout submodules.
 *
 * When the `ssh-key` input is not provided, SSH URLs beginning with `git@github.com:` are converted
 * to HTTPS.
 * @param setSafeDirectory Add repository path as safe.directory for Git global config by running
 * `git config --global --add safe.directory <path>`
 * @param githubServerUrl The base URL for the GitHub instance that you are trying to clone from,
 * will use environment defaults to fetch from the same instance that the workflow is running from
 * unless specified. Example URLs are https://github.com or https://my-ghes-server.example.com
 * @param _customInputs Type-unsafe map where you can put any inputs that are not yet supported by
 * the binding
 * @param _customVersion Allows overriding action's version, for example to use a specific minor
 * version, or a newer version that the binding doesn't yet know about
 */
public data class CheckoutV4 private constructor(
    /**
     * Repository name with owner. For example, actions/checkout
     */
    public val repository: String? = null,
    /**
     * The branch, tag or SHA to checkout. When checking out the repository that triggered a
     * workflow, this defaults to the reference or SHA for that event.  Otherwise, uses the default
     * branch.
     */
    public val ref: String? = null,
    /**
     * Personal access token (PAT) used to fetch the repository. The PAT is configured with the
     * local git config, which enables your scripts to run authenticated git commands. The post-job
     * step removes the PAT.
     *
     * We recommend using a service account with the least permissions necessary. Also when
     * generating a new PAT, select the least scopes necessary.
     *
     * [Learn more about creating and using encrypted
     * secrets](https://help.github.com/en/actions/automating-your-workflow-with-github-actions/creating-and-using-encrypted-secrets)
     */
    public val token: String? = null,
    /**
     * SSH key used to fetch the repository. The SSH key is configured with the local git config,
     * which enables your scripts to run authenticated git commands. The post-job step removes the SSH
     * key.
     *
     * We recommend using a service account with the least permissions necessary.
     *
     * [Learn more about creating and using encrypted
     * secrets](https://help.github.com/en/actions/automating-your-workflow-with-github-actions/creating-and-using-encrypted-secrets)
     */
    public val sshKey: String? = null,
    /**
     * Known hosts in addition to the user and global host key database. The public SSH keys for a
     * host may be obtained using the utility `ssh-keyscan`. For example, `ssh-keyscan github.com`. The
     * public key for github.com is always implicitly added.
     */
    public val sshKnownHosts: String? = null,
    /**
     * Whether to perform strict host key checking. When true, adds the options
     * `StrictHostKeyChecking=yes` and `CheckHostIP=no` to the SSH command line. Use the input
     * `ssh-known-hosts` to configure additional hosts.
     */
    public val sshStrict: Boolean? = null,
    /**
     * The user to use when connecting to the remote SSH host. By default 'git' is used.
     */
    public val sshUser: String? = null,
    /**
     * Whether to configure the token or SSH key with the local git config
     */
    public val persistCredentials: Boolean? = null,
    /**
     * Relative path under $GITHUB_WORKSPACE to place the repository
     */
    public val path: String? = null,
    /**
     * Whether to execute `git clean -ffdx && git reset --hard HEAD` before fetching
     */
    public val clean: Boolean? = null,
    /**
     * Partially clone against a given filter. Overrides sparse-checkout if set.
     */
    public val filter: String? = null,
    /**
     * Do a sparse checkout on given patterns. Each pattern should be separated with new lines.
     */
    public val sparseCheckout: Boolean? = null,
    /**
     * Specifies whether to use cone-mode when doing a sparse checkout.
     */
    public val sparseCheckoutConeMode: Boolean? = null,
    /**
     * Number of commits to fetch. 0 indicates all history for all branches and tags.
     */
    public val fetchDepth: CheckoutV4.FetchDepth? = null,
    /**
     * Whether to fetch tags, even if fetch-depth > 0.
     */
    public val fetchTags: Boolean? = null,
    /**
     * Whether to show progress status output when fetching.
     */
    public val showProgress: Boolean? = null,
    /**
     * Whether to download Git-LFS files
     */
    public val lfs: Boolean? = null,
    /**
     * Whether to checkout submodules: `true` to checkout submodules or `recursive` to recursively
     * checkout submodules.
     *
     * When the `ssh-key` input is not provided, SSH URLs beginning with `git@github.com:` are
     * converted to HTTPS.
     */
    public val submodules: Boolean? = null,
    /**
     * Add repository path as safe.directory for Git global config by running `git
     * config --global --add safe.directory <path>`
     */
    public val setSafeDirectory: Boolean? = null,
    /**
     * The base URL for the GitHub instance that you are trying to clone from, will use environment
     * defaults to fetch from the same instance that the workflow is running from unless specified.
     * Example URLs are https://github.com or https://my-ghes-server.example.com
     */
    public val githubServerUrl: String? = null,
    /**
     * Type-unsafe map where you can put any inputs that are not yet supported by the binding
     */
    public val _customInputs: Map<String, String> = mapOf(),
    /**
     * Allows overriding action's version, for example to use a specific minor version, or a newer
     * version that the binding doesn't yet know about
     */
    public val _customVersion: String? = null,
) : RegularAction<Action.Outputs>("actions", "checkout", _customVersion ?: "v4") {
    public constructor(
        vararg pleaseUseNamedArguments: Unit,
        repository: String? = null,
        ref: String? = null,
        token: String? = null,
        sshKey: String? = null,
        sshKnownHosts: String? = null,
        sshStrict: Boolean? = null,
        sshUser: String? = null,
        persistCredentials: Boolean? = null,
        path: String? = null,
        clean: Boolean? = null,
        filter: String? = null,
        sparseCheckout: Boolean? = null,
        sparseCheckoutConeMode: Boolean? = null,
        fetchDepth: CheckoutV4.FetchDepth? = null,
        fetchTags: Boolean? = null,
        showProgress: Boolean? = null,
        lfs: Boolean? = null,
        submodules: Boolean? = null,
        setSafeDirectory: Boolean? = null,
        githubServerUrl: String? = null,
        _customInputs: Map<String, String> = mapOf(),
        _customVersion: String? = null,
    ) : this(repository=repository, ref=ref, token=token, sshKey=sshKey,
            sshKnownHosts=sshKnownHosts, sshStrict=sshStrict, sshUser=sshUser,
            persistCredentials=persistCredentials, path=path, clean=clean, filter=filter,
            sparseCheckout=sparseCheckout, sparseCheckoutConeMode=sparseCheckoutConeMode,
            fetchDepth=fetchDepth, fetchTags=fetchTags, showProgress=showProgress, lfs=lfs,
            submodules=submodules, setSafeDirectory=setSafeDirectory,
            githubServerUrl=githubServerUrl, _customInputs=_customInputs,
            _customVersion=_customVersion)

    @Suppress("SpreadOperator")
    override fun toYamlArguments(): LinkedHashMap<String, String> = linkedMapOf(
        *listOfNotNull(
            repository?.let { "repository" to it },
            ref?.let { "ref" to it },
            token?.let { "token" to it },
            sshKey?.let { "ssh-key" to it },
            sshKnownHosts?.let { "ssh-known-hosts" to it },
            sshStrict?.let { "ssh-strict" to it.toString() },
            sshUser?.let { "ssh-user" to it },
            persistCredentials?.let { "persist-credentials" to it.toString() },
            path?.let { "path" to it },
            clean?.let { "clean" to it.toString() },
            filter?.let { "filter" to it },
            sparseCheckout?.let { "sparse-checkout" to it.toString() },
            sparseCheckoutConeMode?.let { "sparse-checkout-cone-mode" to it.toString() },
            fetchDepth?.let { "fetch-depth" to it.integerValue.toString() },
            fetchTags?.let { "fetch-tags" to it.toString() },
            showProgress?.let { "show-progress" to it.toString() },
            lfs?.let { "lfs" to it.toString() },
            submodules?.let { "submodules" to it.toString() },
            setSafeDirectory?.let { "set-safe-directory" to it.toString() },
            githubServerUrl?.let { "github-server-url" to it },
            *_customInputs.toList().toTypedArray(),
        ).toTypedArray()
    )

    override fun buildOutputObject(stepId: String): Action.Outputs = Outputs(stepId)

    public sealed class FetchDepth(
        public val integerValue: Int,
    ) {
        public class Value(
            requestedValue: Int,
        ) : CheckoutV4.FetchDepth(requestedValue)

        public object Infinite : CheckoutV4.FetchDepth(0)
    }
}
