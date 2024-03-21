package io.github.typesafegithub.workflows.dsl

import kotlinx.serialization.Contextual

public interface HasCustomArguments {
    @Suppress("ktlint:standard:backing-property-naming", "VariableNaming")
    public val _customArguments: Map<String, @Contextual Any?>
}
