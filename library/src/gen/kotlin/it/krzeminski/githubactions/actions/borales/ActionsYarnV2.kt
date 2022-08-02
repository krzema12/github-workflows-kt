// This file was generated using 'wrapper-generator' module. Don't change it by hand, your changes will
// be overwritten with the next wrapper code regeneration. Instead, consider introducing changes to the
// generator itself.
@file:Suppress("DEPRECATION")

package it.krzeminski.githubactions.actions.borales

import it.krzeminski.githubactions.actions.Action
import kotlin.Deprecated
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.collections.toList
import kotlin.collections.toTypedArray

/**
 * Action: GitHub Action for Yarn
 *
 * Wraps the yarn CLI to enable common yarn commands
 *
 * [Action on GitHub](https://github.com/Borales/actions-yarn)
 */
@Deprecated(
    message = "This action has a newer major version: ActionsYarnV3",
    replaceWith = ReplaceWith("ActionsYarnV3"),
)
public class ActionsYarnV2(
    /**
     * Yarn command
     */
    public val cmd: String,
    /**
     * NPM_AUTH_TOKEN
     */
    public val authToken: String? = null,
    /**
     * NPM_REGISTRY_URL
     */
    public val registryUrl: String? = null,
    /**
     * Type-unsafe map where you can put any inputs that are not yet supported by the wrapper
     */
    public val _customInputs: Map<String, String> = mapOf(),
    /**
     * Allows overriding action's version, for example to use a specific minor version, or a newer
     * version that the wrapper doesn't yet know about
     */
    _customVersion: String? = null,
) : Action("Borales", "actions-yarn", _customVersion ?: "v2.3.0") {
    @Suppress("SpreadOperator")
    public override fun toYamlArguments() = linkedMapOf(
        *listOfNotNull(
            "cmd" to cmd,
            authToken?.let { "auth-token" to it },
            registryUrl?.let { "registry-url" to it },
            *_customInputs.toList().toTypedArray(),
        ).toTypedArray()
    )
}
