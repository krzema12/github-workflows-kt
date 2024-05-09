// This file was generated using action-binding-generator. Don't change it by hand, otherwise your
// changes will be overwritten with the next binding code regeneration.
// See https://github.com/typesafegithub/github-workflows-kt for more info.
@file:Suppress(
    "DataClassPrivateConstructor",
    "UNUSED_PARAMETER",
)

package io.github.typesafegithub.workflows.actions.awsactions

import io.github.typesafegithub.workflows.domain.actions.Action
import io.github.typesafegithub.workflows.domain.actions.RegularAction
import java.util.LinkedHashMap
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.Map
import kotlin.collections.toList
import kotlin.collections.toTypedArray

/**
 * Action: Amazon ECS "Deploy Task Definition" Action for GitHub Actions
 *
 * Registers an Amazon ECS task definition, and deploys it to an ECS service
 *
 * [Action on GitHub](https://github.com/aws-actions/amazon-ecs-deploy-task-definition)
 *
 * @param taskDefinition The path to the ECS task definition file to register
 * @param desiredCount The number of instantiations of the task to place and keep running in your
 * service.
 * @param service The name of the ECS service to deploy to. The action will only register the task
 * definition if no service is given.
 * @param cluster The name of the ECS service's cluster.  Will default to the 'default' cluster
 * @param waitForServiceStability Whether to wait for the ECS service to reach stable state after
 * deploying the new task definition. Valid value is "true". Will default to not waiting.
 * @param waitForMinutes How long to wait for the ECS service to reach stable state, in minutes
 * (default: 30 minutes, max: 6 hours). For CodeDeploy deployments, any wait time configured in the
 * CodeDeploy deployment group will be added to this value.
 * @param codedeployAppspec The path to the AWS CodeDeploy AppSpec file, if the ECS service uses the
 * CODE_DEPLOY deployment controller. Will default to 'appspec.yaml'.
 * @param codedeployApplication The name of the AWS CodeDeploy application, if the ECS service uses
 * the CODE_DEPLOY deployment controller. Will default to 'AppECS-{cluster}-{service}'.
 * @param codedeployDeploymentGroup The name of the AWS CodeDeploy deployment group, if the ECS
 * service uses the CODE_DEPLOY deployment controller. Will default to 'DgpECS-{cluster}-{service}'.
 * @param codedeployDeploymentDescription A description of the deployment, if the ECS service uses
 * the CODE_DEPLOY deployment controller.
 * @param forceNewDeployment Whether to force a new deployment of the service. Valid value is
 * "true". Will default to not force a new deployment.
 * @param _customInputs Type-unsafe map where you can put any inputs that are not yet supported by
 * the binding
 * @param _customVersion Allows overriding action's version, for example to use a specific minor
 * version, or a newer version that the binding doesn't yet know about
 */
public data class AmazonEcsDeployTaskDefinitionV1 private constructor(
    /**
     * The path to the ECS task definition file to register
     */
    public val taskDefinition: String,
    /**
     * The number of instantiations of the task to place and keep running in your service.
     */
    public val desiredCount: Int? = null,
    /**
     * The name of the ECS service to deploy to. The action will only register the task definition
     * if no service is given.
     */
    public val service: String? = null,
    /**
     * The name of the ECS service's cluster.  Will default to the 'default' cluster
     */
    public val cluster: String? = null,
    /**
     * Whether to wait for the ECS service to reach stable state after deploying the new task
     * definition. Valid value is "true". Will default to not waiting.
     */
    public val waitForServiceStability: Boolean? = null,
    /**
     * How long to wait for the ECS service to reach stable state, in minutes (default: 30 minutes,
     * max: 6 hours). For CodeDeploy deployments, any wait time configured in the CodeDeploy deployment
     * group will be added to this value.
     */
    public val waitForMinutes: Int? = null,
    /**
     * The path to the AWS CodeDeploy AppSpec file, if the ECS service uses the CODE_DEPLOY
     * deployment controller. Will default to 'appspec.yaml'.
     */
    public val codedeployAppspec: String? = null,
    /**
     * The name of the AWS CodeDeploy application, if the ECS service uses the CODE_DEPLOY
     * deployment controller. Will default to 'AppECS-{cluster}-{service}'.
     */
    public val codedeployApplication: String? = null,
    /**
     * The name of the AWS CodeDeploy deployment group, if the ECS service uses the CODE_DEPLOY
     * deployment controller. Will default to 'DgpECS-{cluster}-{service}'.
     */
    public val codedeployDeploymentGroup: String? = null,
    /**
     * A description of the deployment, if the ECS service uses the CODE_DEPLOY deployment
     * controller.
     */
    public val codedeployDeploymentDescription: String? = null,
    /**
     * Whether to force a new deployment of the service. Valid value is "true". Will default to not
     * force a new deployment.
     */
    public val forceNewDeployment: Boolean? = null,
    /**
     * Type-unsafe map where you can put any inputs that are not yet supported by the binding
     */
    public val _customInputs: Map<String, String> = mapOf(),
    /**
     * Allows overriding action's version, for example to use a specific minor version, or a newer
     * version that the binding doesn't yet know about
     */
    public val _customVersion: String? = null,
) : RegularAction<AmazonEcsDeployTaskDefinitionV1.Outputs>("aws-actions",
        "amazon-ecs-deploy-task-definition", _customVersion ?: "v1") {
    public constructor(
        vararg pleaseUseNamedArguments: Unit,
        taskDefinition: String,
        desiredCount: Int? = null,
        service: String? = null,
        cluster: String? = null,
        waitForServiceStability: Boolean? = null,
        waitForMinutes: Int? = null,
        codedeployAppspec: String? = null,
        codedeployApplication: String? = null,
        codedeployDeploymentGroup: String? = null,
        codedeployDeploymentDescription: String? = null,
        forceNewDeployment: Boolean? = null,
        _customInputs: Map<String, String> = mapOf(),
        _customVersion: String? = null,
    ) : this(taskDefinition=taskDefinition, desiredCount=desiredCount, service=service,
            cluster=cluster, waitForServiceStability=waitForServiceStability,
            waitForMinutes=waitForMinutes, codedeployAppspec=codedeployAppspec,
            codedeployApplication=codedeployApplication,
            codedeployDeploymentGroup=codedeployDeploymentGroup,
            codedeployDeploymentDescription=codedeployDeploymentDescription,
            forceNewDeployment=forceNewDeployment, _customInputs=_customInputs,
            _customVersion=_customVersion)

    @Suppress("SpreadOperator")
    override fun toYamlArguments(): LinkedHashMap<String, String> = linkedMapOf(
        *listOfNotNull(
            "task-definition" to taskDefinition,
            desiredCount?.let { "desired-count" to it.toString() },
            service?.let { "service" to it },
            cluster?.let { "cluster" to it },
            waitForServiceStability?.let { "wait-for-service-stability" to it.toString() },
            waitForMinutes?.let { "wait-for-minutes" to it.toString() },
            codedeployAppspec?.let { "codedeploy-appspec" to it },
            codedeployApplication?.let { "codedeploy-application" to it },
            codedeployDeploymentGroup?.let { "codedeploy-deployment-group" to it },
            codedeployDeploymentDescription?.let { "codedeploy-deployment-description" to it },
            forceNewDeployment?.let { "force-new-deployment" to it.toString() },
            *_customInputs.toList().toTypedArray(),
        ).toTypedArray()
    )

    override fun buildOutputObject(stepId: String): Outputs = Outputs(stepId)

    public class Outputs(
        stepId: String,
    ) : Action.Outputs(stepId) {
        /**
         * The ARN of the registered ECS task definition
         */
        public val taskDefinitionArn: String = "steps.$stepId.outputs.task-definition-arn"

        /**
         * The deployment ID of the CodeDeploy deployment (if the ECS service uses the CODE_DEPLOY
         * deployment controller
         */
        public val codedeployDeploymentId: String = "steps.$stepId.outputs.codedeploy-deployment-id"
    }
}
