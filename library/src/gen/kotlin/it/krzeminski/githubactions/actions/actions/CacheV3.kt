// This file was generated using 'wrapper-generator' module. Don't change it by hand, your changes will
// be overwritten with the next wrapper code regeneration. Instead, consider introducing changes to the
// generator itself.
package it.krzeminski.githubactions.actions.actions

import it.krzeminski.githubactions.actions.ActionWithOutputs
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.toList
import kotlin.collections.toTypedArray

/**
 * Action: Cache
 *
 * Cache artifacts like dependencies and build outputs to improve workflow execution time
 *
 * [Action on GitHub](https://github.com/actions/cache)
 */
public class CacheV3(
    /**
     * A list of files, directories, and wildcard patterns to cache and restore
     */
    public val path: List<String>,
    /**
     * An explicit key for restoring and saving the cache
     */
    public val key: String,
    /**
     * An ordered list of keys to use for restoring stale cache if no cache hit occurred for key.
     * Note `cache-hit` returns false in this case.
     */
    public val restoreKeys: List<String>? = null,
    /**
     * The chunk size used to split up large files during upload, in bytes
     */
    public val uploadChunkSize: Int? = null,
    /**
     * Type-unsafe map where you can put any inputs that are not yet supported by the wrapper
     */
    public val _customInputs: Map<String, String> = mapOf(),
    /**
     * Allows overriding action's version, for example to use a specific minor version, or a newer
     * version that the wrapper doesn't yet know about
     */
    _customVersion: String? = null,
) : ActionWithOutputs<CacheV3.Outputs>("actions", "cache", _customVersion ?: "v3") {
    @Suppress("SpreadOperator")
    public override fun toYamlArguments() = linkedMapOf(
        *listOfNotNull(
            "path" to path.joinToString("\n"),
            "key" to key,
            restoreKeys?.let { "restore-keys" to it.joinToString("\n") },
            uploadChunkSize?.let { "upload-chunk-size" to it.toString() },
            *_customInputs.toList().toTypedArray(),
        ).toTypedArray()
    )

    public override fun buildOutputObject(stepId: String) = Outputs(stepId)

    public class Outputs(
        private val stepId: String,
    ) {
        /**
         * A boolean value to indicate an exact match was found for the primary key
         */
        public val cacheHit: String = "steps.$stepId.outputs.cache-hit"

        public operator fun `get`(outputName: String) = "steps.$stepId.outputs.$outputName"
    }
}
