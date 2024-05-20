// This file was generated using action-binding-generator. Don't change it by hand, otherwise your
// changes will be overwritten with the next binding code regeneration.
// See https://github.com/typesafegithub/github-workflows-kt for more info.
@file:Suppress(
    "DataClassPrivateConstructor",
    "UNUSED_PARAMETER",
)

package io.github.typesafegithub.workflows.actions.gradle

import io.github.typesafegithub.workflows.domain.actions.Action
import io.github.typesafegithub.workflows.domain.actions.RegularAction
import java.util.LinkedHashMap
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.toList
import kotlin.collections.toTypedArray

/**
 * Action: Gradle Wrapper Validation
 *
 * Validates Gradle Wrapper JAR Files
 *
 * [Action on GitHub](https://github.com/gradle/wrapper-validation-action)
 *
 * @param minWrapperCount Minimum number expected gradle-wrapper.jar files found in the repository.
 * Non-negative number. Higher number is useful in monorepos where each project might have their own
 * wrapper.
 * @param allowSnapshots Allow Gradle snapshot versions during checksum verification. Boolean, true
 * or false.
 * @param allowChecksums Accept arbitrary user-defined checksums as valid. Comma separated list of
 * SHA256 checksums (lowercase hex).
 * @param _customInputs Type-unsafe map where you can put any inputs that are not yet supported by
 * the binding
 * @param _customVersion Allows overriding action's version, for example to use a specific minor
 * version, or a newer version that the binding doesn't yet know about
 */
public data class WrapperValidationActionV3 private constructor(
    /**
     * Minimum number expected gradle-wrapper.jar files found in the repository. Non-negative
     * number. Higher number is useful in monorepos where each project might have their own wrapper.
     */
    public val minWrapperCount: Int? = null,
    /**
     * Allow Gradle snapshot versions during checksum verification. Boolean, true or false.
     */
    public val allowSnapshots: Boolean? = null,
    /**
     * Accept arbitrary user-defined checksums as valid. Comma separated list of SHA256 checksums
     * (lowercase hex).
     */
    public val allowChecksums: List<String>? = null,
    /**
     * Type-unsafe map where you can put any inputs that are not yet supported by the binding
     */
    public val _customInputs: Map<String, String> = mapOf(),
    /**
     * Allows overriding action's version, for example to use a specific minor version, or a newer
     * version that the binding doesn't yet know about
     */
    public val _customVersion: String? = null,
) : RegularAction<WrapperValidationActionV3.Outputs>("gradle", "wrapper-validation-action",
        _customVersion ?: "v3") {
    public constructor(
        vararg pleaseUseNamedArguments: Unit,
        minWrapperCount: Int? = null,
        allowSnapshots: Boolean? = null,
        allowChecksums: List<String>? = null,
        _customInputs: Map<String, String> = mapOf(),
        _customVersion: String? = null,
    ) : this(minWrapperCount=minWrapperCount, allowSnapshots=allowSnapshots,
            allowChecksums=allowChecksums, _customInputs=_customInputs,
            _customVersion=_customVersion)

    @Suppress("SpreadOperator")
    override fun toYamlArguments(): LinkedHashMap<String, String> = linkedMapOf(
        *listOfNotNull(
            minWrapperCount?.let { "min-wrapper-count" to it.toString() },
            allowSnapshots?.let { "allow-snapshots" to it.toString() },
            allowChecksums?.let { "allow-checksums" to it.joinToString(",") },
            *_customInputs.toList().toTypedArray(),
        ).toTypedArray()
    )

    override fun buildOutputObject(stepId: String): Outputs = Outputs(stepId)

    public class Outputs(
        stepId: String,
    ) : Action.Outputs(stepId) {
        /**
         * The path of the Gradle Wrapper(s) JAR that failed validation. Path is a
         * platform-dependent relative path to git repository root. Multiple paths are separated by a |
         * character.
         */
        public val failedWrapper: String = "steps.$stepId.outputs.failed-wrapper"
    }
}
