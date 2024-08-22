package io.github.typesafegithub.workflows.actionbindinggenerator.metadata

/**
 * [Input.required] is in theory a required field in action's metadata, but in practice a lot of actions don't specify
 * it. It's thus a challenge to infer nullability of inputs in the Kotlin bindings. This function tackles this task.
 */
internal fun Input.shouldBeRequiredInBinding() = default == null && required == true
