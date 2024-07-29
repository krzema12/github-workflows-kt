// This file was generated using action-binding-generator. Don't change it by hand, otherwise your
// changes will be overwritten with the next binding code regeneration.
// See https://github.com/typesafegithub/github-workflows-kt for more info.
@file:Suppress(
    "DataClassPrivateConstructor",
    "UNUSED_PARAMETER",
)

package io.github.typesafegithub.workflows.actions.madhead

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
 * Action: intellij-http-client-action
 *
 * IntelliJ HTTP Client CLI GitHub Action – Run Requests and Tests on CI
 *
 * [Action on GitHub](https://github.com/madhead/intellij-http-client-action)
 *
 * @param files HTTP file paths
 * @param socketTimeout Number of milliseconds for socket read
 * @param connectTimeout Number of milliseconds for connection
 * @param insecure Allow insecure SSL connections
 * @param env Name of the environment in config file
 * @param envFile Name of the public environment file
 * @param envVariables Public environment variables ('key=value')
 * @param privateEnvFile Name of the private environment file
 * @param privateEnvVariables Private environment variables ('key=value')
 * @param proxy Proxy setting in format 'scheme://login:password@host:port'
 * @param dockerMode Enables Docker mode. Treat 'localhost' as 'host.docker.internal'
 * @param logLevel Logging level. One of 'BASIC' (default), 'HEADERS', or 'VERBOSE'
 * @param report Creates report about execution in JUnit XML Format. Puts it in folder 'reports' in
 * the current directory
 * @param _customInputs Type-unsafe map where you can put any inputs that are not yet supported by
 * the binding
 * @param _customVersion Allows overriding action's version, for example to use a specific minor
 * version, or a newer version that the binding doesn't yet know about
 */
public data class IntellijHttpClientActionV241 private constructor(
    /**
     * HTTP file paths
     */
    public val files: List<String>,
    /**
     * Number of milliseconds for socket read
     */
    public val socketTimeout: Int? = null,
    /**
     * Number of milliseconds for connection
     */
    public val connectTimeout: Int? = null,
    /**
     * Allow insecure SSL connections
     */
    public val insecure: Boolean? = null,
    /**
     * Name of the environment in config file
     */
    public val env: String? = null,
    /**
     * Name of the public environment file
     */
    public val envFile: String? = null,
    /**
     * Public environment variables ('key=value')
     */
    public val envVariables: List<String>? = null,
    /**
     * Name of the private environment file
     */
    public val privateEnvFile: String? = null,
    /**
     * Private environment variables ('key=value')
     */
    public val privateEnvVariables: List<String>? = null,
    /**
     * Proxy setting in format 'scheme://login:password@host:port'
     */
    public val proxy: String? = null,
    /**
     * Enables Docker mode. Treat 'localhost' as 'host.docker.internal'
     */
    public val dockerMode: Boolean? = null,
    /**
     * Logging level. One of 'BASIC' (default), 'HEADERS', or 'VERBOSE'
     */
    public val logLevel: IntellijHttpClientActionV241.LogLevel? = null,
    /**
     * Creates report about execution in JUnit XML Format. Puts it in folder 'reports' in the
     * current directory
     */
    public val report: Boolean? = null,
    /**
     * Type-unsafe map where you can put any inputs that are not yet supported by the binding
     */
    public val _customInputs: Map<String, String> = mapOf(),
    /**
     * Allows overriding action's version, for example to use a specific minor version, or a newer
     * version that the binding doesn't yet know about
     */
    public val _customVersion: String? = null,
) : RegularAction<Action.Outputs>("madhead", "intellij-http-client-action", _customVersion ?:
        "v241") {
    public constructor(
        vararg pleaseUseNamedArguments: Unit,
        files: List<String>,
        socketTimeout: Int? = null,
        connectTimeout: Int? = null,
        insecure: Boolean? = null,
        env: String? = null,
        envFile: String? = null,
        envVariables: List<String>? = null,
        privateEnvFile: String? = null,
        privateEnvVariables: List<String>? = null,
        proxy: String? = null,
        dockerMode: Boolean? = null,
        logLevel: IntellijHttpClientActionV241.LogLevel? = null,
        report: Boolean? = null,
        _customInputs: Map<String, String> = mapOf(),
        _customVersion: String? = null,
    ) : this(files=files, socketTimeout=socketTimeout, connectTimeout=connectTimeout,
            insecure=insecure, env=env, envFile=envFile, envVariables=envVariables,
            privateEnvFile=privateEnvFile, privateEnvVariables=privateEnvVariables, proxy=proxy,
            dockerMode=dockerMode, logLevel=logLevel, report=report, _customInputs=_customInputs,
            _customVersion=_customVersion)

    @Suppress("SpreadOperator")
    override fun toYamlArguments(): LinkedHashMap<String, String> = linkedMapOf(
        *listOfNotNull(
            "files" to files.joinToString(" "),
            socketTimeout?.let { "socket_timeout" to it.toString() },
            connectTimeout?.let { "connect_timeout" to it.toString() },
            insecure?.let { "insecure" to it.toString() },
            env?.let { "env" to it },
            envFile?.let { "env_file" to it },
            envVariables?.let { "env_variables" to it.joinToString("\n") },
            privateEnvFile?.let { "private_env_file" to it },
            privateEnvVariables?.let { "private_env_variables" to it.joinToString("\n") },
            proxy?.let { "proxy" to it },
            dockerMode?.let { "docker_mode" to it.toString() },
            logLevel?.let { "log_level" to it.stringValue },
            report?.let { "report" to it.toString() },
            *_customInputs.toList().toTypedArray(),
        ).toTypedArray()
    )

    override fun buildOutputObject(stepId: String): Action.Outputs = Outputs(stepId)

    public sealed class LogLevel(
        public val stringValue: String,
    ) {
        public object Basic : IntellijHttpClientActionV241.LogLevel("BASIC")

        public object Headers : IntellijHttpClientActionV241.LogLevel("HEADERS")

        public object Verbose : IntellijHttpClientActionV241.LogLevel("VERBOSE")

        public class Custom(
            customStringValue: String,
        ) : IntellijHttpClientActionV241.LogLevel(customStringValue)
    }
}
