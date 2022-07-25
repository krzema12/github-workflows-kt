package it.krzeminski.githubactions.domain.triggers

import it.krzeminski.githubactions.internal.CaseEnumSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

// https://docs.github.com/en/actions/using-workflows/events-that-trigger-workflows#pull_request_target
@Serializable
data class PullRequestTarget(
    val types: List<Type> = emptyList(),
    val branches: List<String>? = null,
    val branchesIgnore: List<String>? = null,
    val paths: List<String>? = null,
    val pathsIgnore: List<String>? = null,
    override val _customArguments: Map<String, @Contextual Any> = mapOf(),
) : Trigger() {

    init {
        require(!(branches != null && branchesIgnore != null)) {
            "Cannot define both 'branches' and 'branchesIgnore'!"
        }
        require(!(paths != null && pathsIgnore != null)) {
            "Cannot define both 'paths' and 'pathsIgnore'!"
        }
    }

    @InternalSerializationApi
    class Serializer : CaseEnumSerializer<Type>(Type::class.qualifiedName!!, Type.values())

    @OptIn(InternalSerializationApi::class)
    @Serializable(with = Serializer::class)
    enum class Type {
        Assigned,
        Unassigned,
        Labeled,
        Unlabeled,
        Opened,
        Edited,
        Closed,
        Reopened,
        Synchronize,
        ConvertedToDraft,
        ReadyForReview,
        Locked,
        Unlocked,
        ReviewRequested,
        ReviewRequestRemoved,
        AutoMergeEnabled,
        AutoMergeDisabled,
    }
}
