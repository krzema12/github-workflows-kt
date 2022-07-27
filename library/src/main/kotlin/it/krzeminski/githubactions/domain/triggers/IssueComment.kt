package it.krzeminski.githubactions.domain.triggers

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

/**
 * https://docs.github.com/en/actions/using-workflows/events-that-trigger-workflows#issue_comment
 */
@Serializable
data class IssueComment(
    override val _customArguments: Map<String, @Contextual Any> = mapOf(),
) : Trigger()
