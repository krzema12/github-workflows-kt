package io.github.typesafegithub.workflows.actionbindinggenerator.domain

public sealed interface MetadataRevision

public data object NewestForVersion : MetadataRevision

public data object FromLockfile : MetadataRevision

public data class CommitHash(
    val value: String,
) : MetadataRevision
