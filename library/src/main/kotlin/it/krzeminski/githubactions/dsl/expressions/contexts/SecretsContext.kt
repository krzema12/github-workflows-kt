package it.krzeminski.githubactions.dsl.expressions.contexts

import it.krzeminski.githubactions.dsl.expressions.ExpressionContext

/**
 * Encrypted secrets
 *
 * Encrypted secrets allow you to store sensitive information in your organization,
 * repository, or repository environments.
 *
 * https://docs.github.com/en/actions/security-guides/encrypted-secrets
 */
object SecretsContext : ExpressionContext("secrets") {

    /***
     * GITHUB_TOKEN is a secret that is automatically created for every workflow run,
     * and is always included in the secrets context. For more information, see "Automatic token authentication."
     * https://docs.github.com/en/actions/security-guides/automatic-token-authentication
     */
    val GITHUB_TOKEN by propertyToExprPath
}
