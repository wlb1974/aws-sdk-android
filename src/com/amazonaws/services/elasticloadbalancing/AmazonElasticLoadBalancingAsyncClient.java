/*
 * Copyright 2010-2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.elasticloadbalancing;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;

import com.amazonaws.services.elasticloadbalancing.model.*;


/**
 * Asynchronous client for accessing AmazonElasticLoadBalancing.
 * All asynchronous calls made using this client are non-blocking. Callers could either
 * process the result and handle the exceptions in the worker thread by providing a callback handler
 * when making the call, or use the returned Future object to check the result of the call in the calling thread.
 * Elastic Load Balancing <p>
 * Elastic Load Balancing is a cost-effective and easy to use web service to help you improve availability and scalability of your application. It makes
 * it easy for you to distribute application loads between two or more EC2 instances. Elastic Load Balancing enables availability through redundancy and
 * supports traffic growth of your application.
 * </p>
 * <p>
 * This guide provides detailed information about Elastic Load Balancing actions, data types, parameters, and errors.
 * </p>
 * <p>
 * Query requests are HTTP or HTTPS requests that use the HTTP verb GET or POST and a Query parameter named Action or Operation. Action is used
 * throughout this documentation, although Operation is supported for backward compatibility with other AWS Query APIs.
 * </p>
 * <p>
 * This reference guide is based on the current WSDL, which is available at:
 * </p>
 * <p>
 * For detailed information on constructing a query request using the actions, data types, and parameters mentioned in this guide, go to <a
 * href="http://docs.amazonwebservices.com/ElasticLoadBalancing/latest/DeveloperGuide/using-query-api.html"> Using the Query API </a> in the <i>Elastic
 * Load Balancing Developer Guide</i> .
 * </p>
 * <p>
 * For detailed information about Elastic Load Balancing features and their associated API calls, go to <a
 * href="http://docs.amazonwebservices.com/ElasticLoadBalancing/latest/DeveloperGuide/UserScenarios.html"> Using Elastic Load Balancing </a> in the
 * <i>Elastic Load Balancing Developer Guide</i> .
 * </p>
 * <p>
 * See our blog to learn more about {@see <a href="http://mobile.awsblog.com/post/Tx31X75XISXHRH8/Managing-Credentials-in-Mobile-Applications">Managing Credentials in Mobile Applications</a>.}
 * </p>
 */
public class AmazonElasticLoadBalancingAsyncClient extends AmazonElasticLoadBalancingClient
        implements AmazonElasticLoadBalancingAsync {

    /**
     * Executor service for executing asynchronous requests.
     */
    private ExecutorService executorService;


    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonElasticLoadBalancing.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProvider
     */
    public AmazonElasticLoadBalancingAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonElasticLoadBalancing.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonElasticLoadBalancing
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProvider
     */
    public AmazonElasticLoadBalancingAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonElasticLoadBalancing using the specified AWS account credentials.
     * Default client settings will be used, and a default cached thread pool will be
     * created for executing the asynchronous tasks.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonElasticLoadBalancingAsyncClient(AWSCredentials awsCredentials) {
        this(awsCredentials, Executors.newCachedThreadPool());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonElasticLoadBalancing using the specified AWS account credentials
     * and executor service.  Default client settings will be used.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentials
     *            The AWS credentials (access key ID and secret key) to use
     *            when authenticating with AWS services.
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonElasticLoadBalancingAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService) {
        super(awsCredentials);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonElasticLoadBalancing using the specified AWS account credentials,
     * executor service, and client configuration options.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentials
     *            The AWS credentials (access key ID and secret key) to use
     *            when authenticating with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonElasticLoadBalancingAsyncClient(AWSCredentials awsCredentials,
                ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonElasticLoadBalancing using the specified AWS account credentials provider.
     * Default client settings will be used, and a default cached thread pool will be
     * created for executing the asynchronous tasks.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonElasticLoadBalancingAsyncClient(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, Executors.newCachedThreadPool());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonElasticLoadBalancing using the specified AWS account credentials provider
     * and executor service.  Default client settings will be used.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonElasticLoadBalancingAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService) {
        this(awsCredentialsProvider, new ClientConfiguration(), executorService);
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonElasticLoadBalancing using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     */
    public AmazonElasticLoadBalancingAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
                ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, Executors.newCachedThreadPool());
    }

    /**
     * Constructs a new asynchronous client to invoke service methods on
     * AmazonElasticLoadBalancing using the specified AWS account credentials
     * provider, executor service, and client configuration options.
     *
     * <p>
     * All calls made using this new client object are non-blocking, and will immediately
     * return a Java Future object that the caller can later check to see if the service
     * call has actually completed.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration
     *            Client configuration options (ex: max retry limit, proxy
     *            settings, etc).
     * @param executorService
     *            The executor service by which all asynchronous requests will
     *            be executed.
     */
    public AmazonElasticLoadBalancingAsyncClient(AWSCredentialsProvider awsCredentialsProvider,
                ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(awsCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }


    /**
     * Returns the executor service used by this async client to execute
     * requests.
     *
     * @return The executor service used by this async client to execute
     *         requests.
     */
    public ExecutorService getExecutorService() {
        return executorService;
    }

    /**
     * Shuts down the client, releasing all managed resources. This includes
     * forcibly terminating all pending asynchronous service calls. Clients who
     * wish to give pending asynchronous service calls time to complete should
     * call getExecutorService().shutdown() prior to calling this method.
     */
    @Override
    public void shutdown() {
        super.shutdown();
        executorService.shutdownNow();
    }
            
    /**
     * <p>
     * Returns meta-information on the specified LoadBalancer policies
     * defined by the Elastic Load Balancing service. The policy types that
     * are returned from this action can be used in a
     * CreateLoadBalancerPolicy action to instantiate specific policy
     * configurations that will be applied to an Elastic LoadBalancer.
     * </p>
     *
     * @param describeLoadBalancerPolicyTypesRequest Container for the
     *           necessary parameters to execute the DescribeLoadBalancerPolicyTypes
     *           operation on AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLoadBalancerPolicyTypes service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLoadBalancerPolicyTypesResult> describeLoadBalancerPolicyTypesAsync(final DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLoadBalancerPolicyTypesResult>() {
            public DescribeLoadBalancerPolicyTypesResult call() throws Exception {
                return describeLoadBalancerPolicyTypes(describeLoadBalancerPolicyTypesRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Returns meta-information on the specified LoadBalancer policies
     * defined by the Elastic Load Balancing service. The policy types that
     * are returned from this action can be used in a
     * CreateLoadBalancerPolicy action to instantiate specific policy
     * configurations that will be applied to an Elastic LoadBalancer.
     * </p>
     *
     * @param describeLoadBalancerPolicyTypesRequest Container for the
     *           necessary parameters to execute the DescribeLoadBalancerPolicyTypes
     *           operation on AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLoadBalancerPolicyTypes service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLoadBalancerPolicyTypesResult> describeLoadBalancerPolicyTypesAsync(
            final DescribeLoadBalancerPolicyTypesRequest describeLoadBalancerPolicyTypesRequest,
            final AsyncHandler<DescribeLoadBalancerPolicyTypesRequest, DescribeLoadBalancerPolicyTypesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLoadBalancerPolicyTypesResult>() {
            public DescribeLoadBalancerPolicyTypesResult call() throws Exception {
            	DescribeLoadBalancerPolicyTypesResult result;
                try {
            		result = describeLoadBalancerPolicyTypes(describeLoadBalancerPolicyTypesRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(describeLoadBalancerPolicyTypesRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Enables the client to define an application healthcheck for the
     * instances.
     * </p>
     *
     * @param configureHealthCheckRequest Container for the necessary
     *           parameters to execute the ConfigureHealthCheck operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         ConfigureHealthCheck service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ConfigureHealthCheckResult> configureHealthCheckAsync(final ConfigureHealthCheckRequest configureHealthCheckRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ConfigureHealthCheckResult>() {
            public ConfigureHealthCheckResult call() throws Exception {
                return configureHealthCheck(configureHealthCheckRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Enables the client to define an application healthcheck for the
     * instances.
     * </p>
     *
     * @param configureHealthCheckRequest Container for the necessary
     *           parameters to execute the ConfigureHealthCheck operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ConfigureHealthCheck service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ConfigureHealthCheckResult> configureHealthCheckAsync(
            final ConfigureHealthCheckRequest configureHealthCheckRequest,
            final AsyncHandler<ConfigureHealthCheckRequest, ConfigureHealthCheckResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ConfigureHealthCheckResult>() {
            public ConfigureHealthCheckResult call() throws Exception {
            	ConfigureHealthCheckResult result;
                try {
            		result = configureHealthCheck(configureHealthCheckRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(configureHealthCheckRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Removes subnets from the set of configured subnets in the VPC for the
     * LoadBalancer.
     * </p>
     * <p>
     * After a subnet is removed all of the EndPoints registered with the
     * LoadBalancer that are in the removed subnet will go into the
     * <i>OutOfService</i> state. When a subnet is removed, the LoadBalancer
     * will balance the traffic among the remaining routable subnets for the
     * LoadBalancer.
     * </p>
     *
     * @param detachLoadBalancerFromSubnetsRequest Container for the
     *           necessary parameters to execute the DetachLoadBalancerFromSubnets
     *           operation on AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DetachLoadBalancerFromSubnets service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DetachLoadBalancerFromSubnetsResult> detachLoadBalancerFromSubnetsAsync(final DetachLoadBalancerFromSubnetsRequest detachLoadBalancerFromSubnetsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DetachLoadBalancerFromSubnetsResult>() {
            public DetachLoadBalancerFromSubnetsResult call() throws Exception {
                return detachLoadBalancerFromSubnets(detachLoadBalancerFromSubnetsRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Removes subnets from the set of configured subnets in the VPC for the
     * LoadBalancer.
     * </p>
     * <p>
     * After a subnet is removed all of the EndPoints registered with the
     * LoadBalancer that are in the removed subnet will go into the
     * <i>OutOfService</i> state. When a subnet is removed, the LoadBalancer
     * will balance the traffic among the remaining routable subnets for the
     * LoadBalancer.
     * </p>
     *
     * @param detachLoadBalancerFromSubnetsRequest Container for the
     *           necessary parameters to execute the DetachLoadBalancerFromSubnets
     *           operation on AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DetachLoadBalancerFromSubnets service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DetachLoadBalancerFromSubnetsResult> detachLoadBalancerFromSubnetsAsync(
            final DetachLoadBalancerFromSubnetsRequest detachLoadBalancerFromSubnetsRequest,
            final AsyncHandler<DetachLoadBalancerFromSubnetsRequest, DetachLoadBalancerFromSubnetsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DetachLoadBalancerFromSubnetsResult>() {
            public DetachLoadBalancerFromSubnetsResult call() throws Exception {
            	DetachLoadBalancerFromSubnetsResult result;
                try {
            		result = detachLoadBalancerFromSubnets(detachLoadBalancerFromSubnetsRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(detachLoadBalancerFromSubnetsRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Returns detailed descriptions of the policies. If you specify a
     * LoadBalancer name, the operation returns either the descriptions of
     * the specified policies, or descriptions of all the policies created
     * for the LoadBalancer. If you don't specify a LoadBalancer name, the
     * operation returns descriptions of the specified sample policies, or
     * descriptions of all the sample policies. The names of the sample
     * policies have the <code>ELBSample-</code> prefix.
     * </p>
     *
     * @param describeLoadBalancerPoliciesRequest Container for the necessary
     *           parameters to execute the DescribeLoadBalancerPolicies operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLoadBalancerPolicies service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLoadBalancerPoliciesResult> describeLoadBalancerPoliciesAsync(final DescribeLoadBalancerPoliciesRequest describeLoadBalancerPoliciesRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLoadBalancerPoliciesResult>() {
            public DescribeLoadBalancerPoliciesResult call() throws Exception {
                return describeLoadBalancerPolicies(describeLoadBalancerPoliciesRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Returns detailed descriptions of the policies. If you specify a
     * LoadBalancer name, the operation returns either the descriptions of
     * the specified policies, or descriptions of all the policies created
     * for the LoadBalancer. If you don't specify a LoadBalancer name, the
     * operation returns descriptions of the specified sample policies, or
     * descriptions of all the sample policies. The names of the sample
     * policies have the <code>ELBSample-</code> prefix.
     * </p>
     *
     * @param describeLoadBalancerPoliciesRequest Container for the necessary
     *           parameters to execute the DescribeLoadBalancerPolicies operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLoadBalancerPolicies service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLoadBalancerPoliciesResult> describeLoadBalancerPoliciesAsync(
            final DescribeLoadBalancerPoliciesRequest describeLoadBalancerPoliciesRequest,
            final AsyncHandler<DescribeLoadBalancerPoliciesRequest, DescribeLoadBalancerPoliciesResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLoadBalancerPoliciesResult>() {
            public DescribeLoadBalancerPoliciesResult call() throws Exception {
            	DescribeLoadBalancerPoliciesResult result;
                try {
            		result = describeLoadBalancerPolicies(describeLoadBalancerPoliciesRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(describeLoadBalancerPoliciesRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Associates, updates, or disables a policy with a listener on the
     * LoadBalancer. You can associate multiple policies with a listener.
     * </p>
     *
     * @param setLoadBalancerPoliciesOfListenerRequest Container for the
     *           necessary parameters to execute the SetLoadBalancerPoliciesOfListener
     *           operation on AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         SetLoadBalancerPoliciesOfListener service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<SetLoadBalancerPoliciesOfListenerResult> setLoadBalancerPoliciesOfListenerAsync(final SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SetLoadBalancerPoliciesOfListenerResult>() {
            public SetLoadBalancerPoliciesOfListenerResult call() throws Exception {
                return setLoadBalancerPoliciesOfListener(setLoadBalancerPoliciesOfListenerRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Associates, updates, or disables a policy with a listener on the
     * LoadBalancer. You can associate multiple policies with a listener.
     * </p>
     *
     * @param setLoadBalancerPoliciesOfListenerRequest Container for the
     *           necessary parameters to execute the SetLoadBalancerPoliciesOfListener
     *           operation on AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         SetLoadBalancerPoliciesOfListener service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<SetLoadBalancerPoliciesOfListenerResult> setLoadBalancerPoliciesOfListenerAsync(
            final SetLoadBalancerPoliciesOfListenerRequest setLoadBalancerPoliciesOfListenerRequest,
            final AsyncHandler<SetLoadBalancerPoliciesOfListenerRequest, SetLoadBalancerPoliciesOfListenerResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SetLoadBalancerPoliciesOfListenerResult>() {
            public SetLoadBalancerPoliciesOfListenerResult call() throws Exception {
            	SetLoadBalancerPoliciesOfListenerResult result;
                try {
            		result = setLoadBalancerPoliciesOfListener(setLoadBalancerPoliciesOfListenerRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(setLoadBalancerPoliciesOfListenerRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Removes the specified EC2 Availability Zones from the set of
     * configured Availability Zones for the LoadBalancer.
     * </p>
     * <p>
     * There must be at least one Availability Zone registered with a
     * LoadBalancer at all times. A client cannot remove all the Availability
     * Zones from a LoadBalancer. Once an Availability Zone is removed, all
     * the instances registered with the LoadBalancer that are in the removed
     * Availability Zone go into the OutOfService state. Upon Availability
     * Zone removal, the LoadBalancer attempts to equally balance the traffic
     * among its remaining usable Availability Zones. Trying to remove an
     * Availability Zone that was not associated with the LoadBalancer does
     * nothing.
     * </p>
     * <p>
     * <b>NOTE:</b> In order for this call to be successful, the client must
     * have created the LoadBalancer. The client must provide the same
     * account credentials as those that were used to create the
     * LoadBalancer.
     * </p>
     *
     * @param disableAvailabilityZonesForLoadBalancerRequest Container for
     *           the necessary parameters to execute the
     *           DisableAvailabilityZonesForLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DisableAvailabilityZonesForLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DisableAvailabilityZonesForLoadBalancerResult> disableAvailabilityZonesForLoadBalancerAsync(final DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DisableAvailabilityZonesForLoadBalancerResult>() {
            public DisableAvailabilityZonesForLoadBalancerResult call() throws Exception {
                return disableAvailabilityZonesForLoadBalancer(disableAvailabilityZonesForLoadBalancerRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Removes the specified EC2 Availability Zones from the set of
     * configured Availability Zones for the LoadBalancer.
     * </p>
     * <p>
     * There must be at least one Availability Zone registered with a
     * LoadBalancer at all times. A client cannot remove all the Availability
     * Zones from a LoadBalancer. Once an Availability Zone is removed, all
     * the instances registered with the LoadBalancer that are in the removed
     * Availability Zone go into the OutOfService state. Upon Availability
     * Zone removal, the LoadBalancer attempts to equally balance the traffic
     * among its remaining usable Availability Zones. Trying to remove an
     * Availability Zone that was not associated with the LoadBalancer does
     * nothing.
     * </p>
     * <p>
     * <b>NOTE:</b> In order for this call to be successful, the client must
     * have created the LoadBalancer. The client must provide the same
     * account credentials as those that were used to create the
     * LoadBalancer.
     * </p>
     *
     * @param disableAvailabilityZonesForLoadBalancerRequest Container for
     *           the necessary parameters to execute the
     *           DisableAvailabilityZonesForLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DisableAvailabilityZonesForLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DisableAvailabilityZonesForLoadBalancerResult> disableAvailabilityZonesForLoadBalancerAsync(
            final DisableAvailabilityZonesForLoadBalancerRequest disableAvailabilityZonesForLoadBalancerRequest,
            final AsyncHandler<DisableAvailabilityZonesForLoadBalancerRequest, DisableAvailabilityZonesForLoadBalancerResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DisableAvailabilityZonesForLoadBalancerResult>() {
            public DisableAvailabilityZonesForLoadBalancerResult call() throws Exception {
            	DisableAvailabilityZonesForLoadBalancerResult result;
                try {
            		result = disableAvailabilityZonesForLoadBalancer(disableAvailabilityZonesForLoadBalancerRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(disableAvailabilityZonesForLoadBalancerRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Returns the current state of the instances of the specified
     * LoadBalancer. If no instances are specified, the state of all the
     * instances for the LoadBalancer is returned.
     * </p>
     * <p>
     * <b>NOTE:</b> The client must have created the specified input
     * LoadBalancer in order to retrieve this information; the client must
     * provide the same account credentials as those that were used to create
     * the LoadBalancer.
     * </p>
     *
     * @param describeInstanceHealthRequest Container for the necessary
     *           parameters to execute the DescribeInstanceHealth operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeInstanceHealth service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeInstanceHealthResult> describeInstanceHealthAsync(final DescribeInstanceHealthRequest describeInstanceHealthRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeInstanceHealthResult>() {
            public DescribeInstanceHealthResult call() throws Exception {
                return describeInstanceHealth(describeInstanceHealthRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Returns the current state of the instances of the specified
     * LoadBalancer. If no instances are specified, the state of all the
     * instances for the LoadBalancer is returned.
     * </p>
     * <p>
     * <b>NOTE:</b> The client must have created the specified input
     * LoadBalancer in order to retrieve this information; the client must
     * provide the same account credentials as those that were used to create
     * the LoadBalancer.
     * </p>
     *
     * @param describeInstanceHealthRequest Container for the necessary
     *           parameters to execute the DescribeInstanceHealth operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeInstanceHealth service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeInstanceHealthResult> describeInstanceHealthAsync(
            final DescribeInstanceHealthRequest describeInstanceHealthRequest,
            final AsyncHandler<DescribeInstanceHealthRequest, DescribeInstanceHealthResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeInstanceHealthResult>() {
            public DescribeInstanceHealthResult call() throws Exception {
            	DescribeInstanceHealthResult result;
                try {
            		result = describeInstanceHealth(describeInstanceHealthRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(describeInstanceHealthRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Deletes a policy from the LoadBalancer. The specified policy must not
     * be enabled for any listeners.
     * </p>
     *
     * @param deleteLoadBalancerPolicyRequest Container for the necessary
     *           parameters to execute the DeleteLoadBalancerPolicy operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLoadBalancerPolicy service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DeleteLoadBalancerPolicyResult> deleteLoadBalancerPolicyAsync(final DeleteLoadBalancerPolicyRequest deleteLoadBalancerPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeleteLoadBalancerPolicyResult>() {
            public DeleteLoadBalancerPolicyResult call() throws Exception {
                return deleteLoadBalancerPolicy(deleteLoadBalancerPolicyRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Deletes a policy from the LoadBalancer. The specified policy must not
     * be enabled for any listeners.
     * </p>
     *
     * @param deleteLoadBalancerPolicyRequest Container for the necessary
     *           parameters to execute the DeleteLoadBalancerPolicy operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLoadBalancerPolicy service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DeleteLoadBalancerPolicyResult> deleteLoadBalancerPolicyAsync(
            final DeleteLoadBalancerPolicyRequest deleteLoadBalancerPolicyRequest,
            final AsyncHandler<DeleteLoadBalancerPolicyRequest, DeleteLoadBalancerPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeleteLoadBalancerPolicyResult>() {
            public DeleteLoadBalancerPolicyResult call() throws Exception {
            	DeleteLoadBalancerPolicyResult result;
                try {
            		result = deleteLoadBalancerPolicy(deleteLoadBalancerPolicyRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(deleteLoadBalancerPolicyRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Creates a new policy that contains the necessary attributes depending
     * on the policy type. Policies are settings that are saved for your
     * Elastic LoadBalancer and that can be applied to the front-end
     * listener, or the back-end application server, depending on your policy
     * type.
     * </p>
     *
     * @param createLoadBalancerPolicyRequest Container for the necessary
     *           parameters to execute the CreateLoadBalancerPolicy operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLoadBalancerPolicy service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateLoadBalancerPolicyResult> createLoadBalancerPolicyAsync(final CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateLoadBalancerPolicyResult>() {
            public CreateLoadBalancerPolicyResult call() throws Exception {
                return createLoadBalancerPolicy(createLoadBalancerPolicyRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Creates a new policy that contains the necessary attributes depending
     * on the policy type. Policies are settings that are saved for your
     * Elastic LoadBalancer and that can be applied to the front-end
     * listener, or the back-end application server, depending on your policy
     * type.
     * </p>
     *
     * @param createLoadBalancerPolicyRequest Container for the necessary
     *           parameters to execute the CreateLoadBalancerPolicy operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLoadBalancerPolicy service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateLoadBalancerPolicyResult> createLoadBalancerPolicyAsync(
            final CreateLoadBalancerPolicyRequest createLoadBalancerPolicyRequest,
            final AsyncHandler<CreateLoadBalancerPolicyRequest, CreateLoadBalancerPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateLoadBalancerPolicyResult>() {
            public CreateLoadBalancerPolicyResult call() throws Exception {
            	CreateLoadBalancerPolicyResult result;
                try {
            		result = createLoadBalancerPolicy(createLoadBalancerPolicyRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(createLoadBalancerPolicyRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Adds one or more EC2 Availability Zones to the LoadBalancer.
     * </p>
     * <p>
     * The LoadBalancer evenly distributes requests across all its
     * registered Availability Zones that contain instances. As a result, the
     * client must ensure that its LoadBalancer is appropriately scaled for
     * each registered Availability Zone.
     * </p>
     * <p>
     * <b>NOTE:</b> The new EC2 Availability Zones to be added must be in the
     * same EC2 Region as the Availability Zones for which the LoadBalancer
     * was created.
     * </p>
     *
     * @param enableAvailabilityZonesForLoadBalancerRequest Container for the
     *           necessary parameters to execute the
     *           EnableAvailabilityZonesForLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         EnableAvailabilityZonesForLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<EnableAvailabilityZonesForLoadBalancerResult> enableAvailabilityZonesForLoadBalancerAsync(final EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<EnableAvailabilityZonesForLoadBalancerResult>() {
            public EnableAvailabilityZonesForLoadBalancerResult call() throws Exception {
                return enableAvailabilityZonesForLoadBalancer(enableAvailabilityZonesForLoadBalancerRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Adds one or more EC2 Availability Zones to the LoadBalancer.
     * </p>
     * <p>
     * The LoadBalancer evenly distributes requests across all its
     * registered Availability Zones that contain instances. As a result, the
     * client must ensure that its LoadBalancer is appropriately scaled for
     * each registered Availability Zone.
     * </p>
     * <p>
     * <b>NOTE:</b> The new EC2 Availability Zones to be added must be in the
     * same EC2 Region as the Availability Zones for which the LoadBalancer
     * was created.
     * </p>
     *
     * @param enableAvailabilityZonesForLoadBalancerRequest Container for the
     *           necessary parameters to execute the
     *           EnableAvailabilityZonesForLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         EnableAvailabilityZonesForLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<EnableAvailabilityZonesForLoadBalancerResult> enableAvailabilityZonesForLoadBalancerAsync(
            final EnableAvailabilityZonesForLoadBalancerRequest enableAvailabilityZonesForLoadBalancerRequest,
            final AsyncHandler<EnableAvailabilityZonesForLoadBalancerRequest, EnableAvailabilityZonesForLoadBalancerResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<EnableAvailabilityZonesForLoadBalancerResult>() {
            public EnableAvailabilityZonesForLoadBalancerResult call() throws Exception {
            	EnableAvailabilityZonesForLoadBalancerResult result;
                try {
            		result = enableAvailabilityZonesForLoadBalancer(enableAvailabilityZonesForLoadBalancerRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(enableAvailabilityZonesForLoadBalancerRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Creates one or more listeners on a LoadBalancer for the specified
     * port. If a listener with the given port does not already exist, it
     * will be created; otherwise, the properties of the new listener must
     * match the properties of the existing listener.
     * </p>
     *
     * @param createLoadBalancerListenersRequest Container for the necessary
     *           parameters to execute the CreateLoadBalancerListeners operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLoadBalancerListeners service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createLoadBalancerListenersAsync(final CreateLoadBalancerListenersRequest createLoadBalancerListenersRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                createLoadBalancerListeners(createLoadBalancerListenersRequest);
                return null;
		    }
		});
    }

    
    /**
     * <p>
     * Creates one or more listeners on a LoadBalancer for the specified
     * port. If a listener with the given port does not already exist, it
     * will be created; otherwise, the properties of the new listener must
     * match the properties of the existing listener.
     * </p>
     *
     * @param createLoadBalancerListenersRequest Container for the necessary
     *           parameters to execute the CreateLoadBalancerListeners operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLoadBalancerListeners service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> createLoadBalancerListenersAsync(
            final CreateLoadBalancerListenersRequest createLoadBalancerListenersRequest,
            final AsyncHandler<CreateLoadBalancerListenersRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
            	try {
            		createLoadBalancerListeners(createLoadBalancerListenersRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(createLoadBalancerListenersRequest, null);
               	return null;
		    }
		});
    }
    
    /**
     * <p>
     * Creates a new LoadBalancer.
     * </p>
     * <p>
     * After the call has completed successfully, a new LoadBalancer is
     * created; however, it will not be usable until at least one instance
     * has been registered. When the LoadBalancer creation is completed, the
     * client can check whether or not it is usable by using the
     * DescribeInstanceHealth API. The LoadBalancer is usable as soon as any
     * registered instance is <i>InService</i> .
     * 
     * </p>
     * <p>
     * <b>NOTE:</b> Currently, the client's quota of LoadBalancers is limited
     * to ten per Region.
     * </p>
     * <p>
     * <b>NOTE:</b> LoadBalancer DNS names vary depending on the Region
     * they're created in. For LoadBalancers created in the United States,
     * the DNS name ends with: us-east-1.elb.amazonaws.com (for the US
     * Standard Region) us-west-1.elb.amazonaws.com (for the Northern
     * California Region) For LoadBalancers created in the EU (Ireland)
     * Region, the DNS name ends with: eu-west-1.elb.amazonaws.com
     * </p>
     *
     * @param createLoadBalancerRequest Container for the necessary
     *           parameters to execute the CreateLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateLoadBalancerResult> createLoadBalancerAsync(final CreateLoadBalancerRequest createLoadBalancerRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateLoadBalancerResult>() {
            public CreateLoadBalancerResult call() throws Exception {
                return createLoadBalancer(createLoadBalancerRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Creates a new LoadBalancer.
     * </p>
     * <p>
     * After the call has completed successfully, a new LoadBalancer is
     * created; however, it will not be usable until at least one instance
     * has been registered. When the LoadBalancer creation is completed, the
     * client can check whether or not it is usable by using the
     * DescribeInstanceHealth API. The LoadBalancer is usable as soon as any
     * registered instance is <i>InService</i> .
     * 
     * </p>
     * <p>
     * <b>NOTE:</b> Currently, the client's quota of LoadBalancers is limited
     * to ten per Region.
     * </p>
     * <p>
     * <b>NOTE:</b> LoadBalancer DNS names vary depending on the Region
     * they're created in. For LoadBalancers created in the United States,
     * the DNS name ends with: us-east-1.elb.amazonaws.com (for the US
     * Standard Region) us-west-1.elb.amazonaws.com (for the Northern
     * California Region) For LoadBalancers created in the EU (Ireland)
     * Region, the DNS name ends with: eu-west-1.elb.amazonaws.com
     * </p>
     *
     * @param createLoadBalancerRequest Container for the necessary
     *           parameters to execute the CreateLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateLoadBalancerResult> createLoadBalancerAsync(
            final CreateLoadBalancerRequest createLoadBalancerRequest,
            final AsyncHandler<CreateLoadBalancerRequest, CreateLoadBalancerResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateLoadBalancerResult>() {
            public CreateLoadBalancerResult call() throws Exception {
            	CreateLoadBalancerResult result;
                try {
            		result = createLoadBalancer(createLoadBalancerRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(createLoadBalancerRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Deletes the specified LoadBalancer.
     * </p>
     * <p>
     * If attempting to recreate the LoadBalancer, the client must
     * reconfigure all the settings. The DNS name associated with a deleted
     * LoadBalancer will no longer be usable. Once deleted, the name and
     * associated DNS record of the LoadBalancer no longer exist and traffic
     * sent to any of its IP addresses will no longer be delivered to client
     * instances. The client will not receive the same DNS name even if a new
     * LoadBalancer with same LoadBalancerName is created.
     * </p>
     * <p>
     * To successfully call this API, the client must provide the same
     * account credentials as were used to create the LoadBalancer.
     * </p>
     * <p>
     * <b>NOTE:</b> By design, if the LoadBalancer does not exist or has
     * already been deleted, DeleteLoadBalancer still succeeds.
     * </p>
     *
     * @param deleteLoadBalancerRequest Container for the necessary
     *           parameters to execute the DeleteLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteLoadBalancerAsync(final DeleteLoadBalancerRequest deleteLoadBalancerRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteLoadBalancer(deleteLoadBalancerRequest);
                return null;
		    }
		});
    }

    
    /**
     * <p>
     * Deletes the specified LoadBalancer.
     * </p>
     * <p>
     * If attempting to recreate the LoadBalancer, the client must
     * reconfigure all the settings. The DNS name associated with a deleted
     * LoadBalancer will no longer be usable. Once deleted, the name and
     * associated DNS record of the LoadBalancer no longer exist and traffic
     * sent to any of its IP addresses will no longer be delivered to client
     * instances. The client will not receive the same DNS name even if a new
     * LoadBalancer with same LoadBalancerName is created.
     * </p>
     * <p>
     * To successfully call this API, the client must provide the same
     * account credentials as were used to create the LoadBalancer.
     * </p>
     * <p>
     * <b>NOTE:</b> By design, if the LoadBalancer does not exist or has
     * already been deleted, DeleteLoadBalancer still succeeds.
     * </p>
     *
     * @param deleteLoadBalancerRequest Container for the necessary
     *           parameters to execute the DeleteLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteLoadBalancerAsync(
            final DeleteLoadBalancerRequest deleteLoadBalancerRequest,
            final AsyncHandler<DeleteLoadBalancerRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
            	try {
            		deleteLoadBalancer(deleteLoadBalancerRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(deleteLoadBalancerRequest, null);
               	return null;
		    }
		});
    }
    
    /**
     * <p>
     * Replaces the current set of policies associated with a port on which
     * the back-end server is listening with a new set of policies. After the
     * policies have been created using CreateLoadBalancerPolicy, they can be
     * applied here as a list. At this time, only the back-end server
     * authentication policy type can be applied to the back-end ports; this
     * policy type is composed of multiple public key policies.
     * </p>
     *
     * @param setLoadBalancerPoliciesForBackendServerRequest Container for
     *           the necessary parameters to execute the
     *           SetLoadBalancerPoliciesForBackendServer operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         SetLoadBalancerPoliciesForBackendServer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<SetLoadBalancerPoliciesForBackendServerResult> setLoadBalancerPoliciesForBackendServerAsync(final SetLoadBalancerPoliciesForBackendServerRequest setLoadBalancerPoliciesForBackendServerRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SetLoadBalancerPoliciesForBackendServerResult>() {
            public SetLoadBalancerPoliciesForBackendServerResult call() throws Exception {
                return setLoadBalancerPoliciesForBackendServer(setLoadBalancerPoliciesForBackendServerRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Replaces the current set of policies associated with a port on which
     * the back-end server is listening with a new set of policies. After the
     * policies have been created using CreateLoadBalancerPolicy, they can be
     * applied here as a list. At this time, only the back-end server
     * authentication policy type can be applied to the back-end ports; this
     * policy type is composed of multiple public key policies.
     * </p>
     *
     * @param setLoadBalancerPoliciesForBackendServerRequest Container for
     *           the necessary parameters to execute the
     *           SetLoadBalancerPoliciesForBackendServer operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         SetLoadBalancerPoliciesForBackendServer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<SetLoadBalancerPoliciesForBackendServerResult> setLoadBalancerPoliciesForBackendServerAsync(
            final SetLoadBalancerPoliciesForBackendServerRequest setLoadBalancerPoliciesForBackendServerRequest,
            final AsyncHandler<SetLoadBalancerPoliciesForBackendServerRequest, SetLoadBalancerPoliciesForBackendServerResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<SetLoadBalancerPoliciesForBackendServerResult>() {
            public SetLoadBalancerPoliciesForBackendServerResult call() throws Exception {
            	SetLoadBalancerPoliciesForBackendServerResult result;
                try {
            		result = setLoadBalancerPoliciesForBackendServer(setLoadBalancerPoliciesForBackendServerRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(setLoadBalancerPoliciesForBackendServerRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Deletes listeners from the LoadBalancer for the specified port.
     * </p>
     *
     * @param deleteLoadBalancerListenersRequest Container for the necessary
     *           parameters to execute the DeleteLoadBalancerListeners operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLoadBalancerListeners service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteLoadBalancerListenersAsync(final DeleteLoadBalancerListenersRequest deleteLoadBalancerListenersRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                deleteLoadBalancerListeners(deleteLoadBalancerListenersRequest);
                return null;
		    }
		});
    }

    
    /**
     * <p>
     * Deletes listeners from the LoadBalancer for the specified port.
     * </p>
     *
     * @param deleteLoadBalancerListenersRequest Container for the necessary
     *           parameters to execute the DeleteLoadBalancerListeners operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeleteLoadBalancerListeners service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> deleteLoadBalancerListenersAsync(
            final DeleteLoadBalancerListenersRequest deleteLoadBalancerListenersRequest,
            final AsyncHandler<DeleteLoadBalancerListenersRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
            	try {
            		deleteLoadBalancerListeners(deleteLoadBalancerListenersRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(deleteLoadBalancerListenersRequest, null);
               	return null;
		    }
		});
    }
    
    /**
     * <p>
     * Deregisters instances from the LoadBalancer. Once the instance is
     * deregistered, it will stop receiving traffic from the LoadBalancer.
     * </p>
     * <p>
     * In order to successfully call this API, the same account credentials
     * as those used to create the LoadBalancer must be provided.
     * </p>
     *
     * @param deregisterInstancesFromLoadBalancerRequest Container for the
     *           necessary parameters to execute the
     *           DeregisterInstancesFromLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DeregisterInstancesFromLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DeregisterInstancesFromLoadBalancerResult> deregisterInstancesFromLoadBalancerAsync(final DeregisterInstancesFromLoadBalancerRequest deregisterInstancesFromLoadBalancerRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeregisterInstancesFromLoadBalancerResult>() {
            public DeregisterInstancesFromLoadBalancerResult call() throws Exception {
                return deregisterInstancesFromLoadBalancer(deregisterInstancesFromLoadBalancerRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Deregisters instances from the LoadBalancer. Once the instance is
     * deregistered, it will stop receiving traffic from the LoadBalancer.
     * </p>
     * <p>
     * In order to successfully call this API, the same account credentials
     * as those used to create the LoadBalancer must be provided.
     * </p>
     *
     * @param deregisterInstancesFromLoadBalancerRequest Container for the
     *           necessary parameters to execute the
     *           DeregisterInstancesFromLoadBalancer operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DeregisterInstancesFromLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DeregisterInstancesFromLoadBalancerResult> deregisterInstancesFromLoadBalancerAsync(
            final DeregisterInstancesFromLoadBalancerRequest deregisterInstancesFromLoadBalancerRequest,
            final AsyncHandler<DeregisterInstancesFromLoadBalancerRequest, DeregisterInstancesFromLoadBalancerResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DeregisterInstancesFromLoadBalancerResult>() {
            public DeregisterInstancesFromLoadBalancerResult call() throws Exception {
            	DeregisterInstancesFromLoadBalancerResult result;
                try {
            		result = deregisterInstancesFromLoadBalancer(deregisterInstancesFromLoadBalancerRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(deregisterInstancesFromLoadBalancerRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Sets the certificate that terminates the specified listener's SSL
     * connections. The specified certificate replaces any prior certificate
     * that was used on the same LoadBalancer and port.
     * </p>
     *
     * @param setLoadBalancerListenerSSLCertificateRequest Container for the
     *           necessary parameters to execute the
     *           SetLoadBalancerListenerSSLCertificate operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         SetLoadBalancerListenerSSLCertificate service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> setLoadBalancerListenerSSLCertificateAsync(final SetLoadBalancerListenerSSLCertificateRequest setLoadBalancerListenerSSLCertificateRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
                setLoadBalancerListenerSSLCertificate(setLoadBalancerListenerSSLCertificateRequest);
                return null;
		    }
		});
    }

    
    /**
     * <p>
     * Sets the certificate that terminates the specified listener's SSL
     * connections. The specified certificate replaces any prior certificate
     * that was used on the same LoadBalancer and port.
     * </p>
     *
     * @param setLoadBalancerListenerSSLCertificateRequest Container for the
     *           necessary parameters to execute the
     *           SetLoadBalancerListenerSSLCertificate operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         SetLoadBalancerListenerSSLCertificate service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<Void> setLoadBalancerListenerSSLCertificateAsync(
            final SetLoadBalancerListenerSSLCertificateRequest setLoadBalancerListenerSSLCertificateRequest,
            final AsyncHandler<SetLoadBalancerListenerSSLCertificateRequest, Void> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<Void>() {
            public Void call() throws Exception {
            	try {
            		setLoadBalancerListenerSSLCertificate(setLoadBalancerListenerSSLCertificateRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(setLoadBalancerListenerSSLCertificateRequest, null);
               	return null;
		    }
		});
    }
    
    /**
     * <p>
     * Generates a stickiness policy with sticky session lifetimes
     * controlled by the lifetime of the browser (user-agent) or a specified
     * expiration period. This policy can be associated only with HTTP/HTTPS
     * listeners.
     * </p>
     * <p>
     * When a LoadBalancer implements this policy, the LoadBalancer uses a
     * special cookie to track the backend server instance for each request.
     * When the LoadBalancer receives a request, it first checks to see if
     * this cookie is present in the request. If so, the LoadBalancer sends
     * the request to the application server specified in the cookie. If not,
     * the LoadBalancer sends the request to a server that is chosen based on
     * the existing load balancing algorithm.
     * </p>
     * <p>
     * A cookie is inserted into the response for binding subsequent
     * requests from the same user to that server. The validity of the cookie
     * is based on the cookie expiration time, which is specified in the
     * policy configuration.
     * </p>
     *
     * @param createLBCookieStickinessPolicyRequest Container for the
     *           necessary parameters to execute the CreateLBCookieStickinessPolicy
     *           operation on AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLBCookieStickinessPolicy service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateLBCookieStickinessPolicyResult> createLBCookieStickinessPolicyAsync(final CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateLBCookieStickinessPolicyResult>() {
            public CreateLBCookieStickinessPolicyResult call() throws Exception {
                return createLBCookieStickinessPolicy(createLBCookieStickinessPolicyRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Generates a stickiness policy with sticky session lifetimes
     * controlled by the lifetime of the browser (user-agent) or a specified
     * expiration period. This policy can be associated only with HTTP/HTTPS
     * listeners.
     * </p>
     * <p>
     * When a LoadBalancer implements this policy, the LoadBalancer uses a
     * special cookie to track the backend server instance for each request.
     * When the LoadBalancer receives a request, it first checks to see if
     * this cookie is present in the request. If so, the LoadBalancer sends
     * the request to the application server specified in the cookie. If not,
     * the LoadBalancer sends the request to a server that is chosen based on
     * the existing load balancing algorithm.
     * </p>
     * <p>
     * A cookie is inserted into the response for binding subsequent
     * requests from the same user to that server. The validity of the cookie
     * is based on the cookie expiration time, which is specified in the
     * policy configuration.
     * </p>
     *
     * @param createLBCookieStickinessPolicyRequest Container for the
     *           necessary parameters to execute the CreateLBCookieStickinessPolicy
     *           operation on AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateLBCookieStickinessPolicy service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateLBCookieStickinessPolicyResult> createLBCookieStickinessPolicyAsync(
            final CreateLBCookieStickinessPolicyRequest createLBCookieStickinessPolicyRequest,
            final AsyncHandler<CreateLBCookieStickinessPolicyRequest, CreateLBCookieStickinessPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateLBCookieStickinessPolicyResult>() {
            public CreateLBCookieStickinessPolicyResult call() throws Exception {
            	CreateLBCookieStickinessPolicyResult result;
                try {
            		result = createLBCookieStickinessPolicy(createLBCookieStickinessPolicyRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(createLBCookieStickinessPolicyRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Adds one or more subnets to the set of configured subnets in the VPC
     * for the LoadBalancer.
     * </p>
     * <p>
     * The Loadbalancers evenly distribute requests across all of the
     * registered subnets.
     * </p>
     *
     * @param attachLoadBalancerToSubnetsRequest Container for the necessary
     *           parameters to execute the AttachLoadBalancerToSubnets operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         AttachLoadBalancerToSubnets service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<AttachLoadBalancerToSubnetsResult> attachLoadBalancerToSubnetsAsync(final AttachLoadBalancerToSubnetsRequest attachLoadBalancerToSubnetsRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<AttachLoadBalancerToSubnetsResult>() {
            public AttachLoadBalancerToSubnetsResult call() throws Exception {
                return attachLoadBalancerToSubnets(attachLoadBalancerToSubnetsRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Adds one or more subnets to the set of configured subnets in the VPC
     * for the LoadBalancer.
     * </p>
     * <p>
     * The Loadbalancers evenly distribute requests across all of the
     * registered subnets.
     * </p>
     *
     * @param attachLoadBalancerToSubnetsRequest Container for the necessary
     *           parameters to execute the AttachLoadBalancerToSubnets operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         AttachLoadBalancerToSubnets service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<AttachLoadBalancerToSubnetsResult> attachLoadBalancerToSubnetsAsync(
            final AttachLoadBalancerToSubnetsRequest attachLoadBalancerToSubnetsRequest,
            final AsyncHandler<AttachLoadBalancerToSubnetsRequest, AttachLoadBalancerToSubnetsResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<AttachLoadBalancerToSubnetsResult>() {
            public AttachLoadBalancerToSubnetsResult call() throws Exception {
            	AttachLoadBalancerToSubnetsResult result;
                try {
            		result = attachLoadBalancerToSubnets(attachLoadBalancerToSubnetsRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(attachLoadBalancerToSubnetsRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Generates a stickiness policy with sticky session lifetimes that
     * follow that of an application-generated cookie. This policy can be
     * associated only with HTTP/HTTPS listeners.
     * </p>
     * <p>
     * This policy is similar to the policy created by
     * CreateLBCookieStickinessPolicy, except that the lifetime of the
     * special Elastic Load Balancing cookie follows the lifetime of the
     * application-generated cookie specified in the policy configuration.
     * The LoadBalancer only inserts a new stickiness cookie when the
     * application response includes a new application cookie.
     * </p>
     * <p>
     * If the application cookie is explicitly removed or expires, the
     * session stops being sticky until a new application cookie is issued.
     * </p>
     * <p>
     * <b>NOTE:</b> An application client must receive and send two cookies:
     * the application-generated cookie and the special Elastic Load
     * Balancing cookie named AWSELB. This is the default behavior for many
     * common web browsers.
     * </p>
     *
     * @param createAppCookieStickinessPolicyRequest Container for the
     *           necessary parameters to execute the CreateAppCookieStickinessPolicy
     *           operation on AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         CreateAppCookieStickinessPolicy service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateAppCookieStickinessPolicyResult> createAppCookieStickinessPolicyAsync(final CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateAppCookieStickinessPolicyResult>() {
            public CreateAppCookieStickinessPolicyResult call() throws Exception {
                return createAppCookieStickinessPolicy(createAppCookieStickinessPolicyRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Generates a stickiness policy with sticky session lifetimes that
     * follow that of an application-generated cookie. This policy can be
     * associated only with HTTP/HTTPS listeners.
     * </p>
     * <p>
     * This policy is similar to the policy created by
     * CreateLBCookieStickinessPolicy, except that the lifetime of the
     * special Elastic Load Balancing cookie follows the lifetime of the
     * application-generated cookie specified in the policy configuration.
     * The LoadBalancer only inserts a new stickiness cookie when the
     * application response includes a new application cookie.
     * </p>
     * <p>
     * If the application cookie is explicitly removed or expires, the
     * session stops being sticky until a new application cookie is issued.
     * </p>
     * <p>
     * <b>NOTE:</b> An application client must receive and send two cookies:
     * the application-generated cookie and the special Elastic Load
     * Balancing cookie named AWSELB. This is the default behavior for many
     * common web browsers.
     * </p>
     *
     * @param createAppCookieStickinessPolicyRequest Container for the
     *           necessary parameters to execute the CreateAppCookieStickinessPolicy
     *           operation on AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         CreateAppCookieStickinessPolicy service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<CreateAppCookieStickinessPolicyResult> createAppCookieStickinessPolicyAsync(
            final CreateAppCookieStickinessPolicyRequest createAppCookieStickinessPolicyRequest,
            final AsyncHandler<CreateAppCookieStickinessPolicyRequest, CreateAppCookieStickinessPolicyResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<CreateAppCookieStickinessPolicyResult>() {
            public CreateAppCookieStickinessPolicyResult call() throws Exception {
            	CreateAppCookieStickinessPolicyResult result;
                try {
            		result = createAppCookieStickinessPolicy(createAppCookieStickinessPolicyRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(createAppCookieStickinessPolicyRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Adds new instances to the LoadBalancer.
     * </p>
     * <p>
     * Once the instance is registered, it starts receiving traffic and
     * requests from the LoadBalancer. Any instance that is not in any of the
     * Availability Zones registered for the LoadBalancer will be moved to
     * the <i>OutOfService</i> state. It will move to the <i>InService</i>
     * state when the Availability Zone is added to the LoadBalancer.
     * </p>
     * <p>
     * <b>NOTE:</b> In order for this call to be successful, the client must
     * have created the LoadBalancer. The client must provide the same
     * account credentials as those that were used to create the
     * LoadBalancer.
     * </p>
     * <p>
     * <b>NOTE:</b> Completion of this API does not guarantee that operation
     * has completed. Rather, it means that the request has been registered
     * and the changes will happen shortly.
     * </p>
     *
     * @param registerInstancesWithLoadBalancerRequest Container for the
     *           necessary parameters to execute the RegisterInstancesWithLoadBalancer
     *           operation on AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         RegisterInstancesWithLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<RegisterInstancesWithLoadBalancerResult> registerInstancesWithLoadBalancerAsync(final RegisterInstancesWithLoadBalancerRequest registerInstancesWithLoadBalancerRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<RegisterInstancesWithLoadBalancerResult>() {
            public RegisterInstancesWithLoadBalancerResult call() throws Exception {
                return registerInstancesWithLoadBalancer(registerInstancesWithLoadBalancerRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Adds new instances to the LoadBalancer.
     * </p>
     * <p>
     * Once the instance is registered, it starts receiving traffic and
     * requests from the LoadBalancer. Any instance that is not in any of the
     * Availability Zones registered for the LoadBalancer will be moved to
     * the <i>OutOfService</i> state. It will move to the <i>InService</i>
     * state when the Availability Zone is added to the LoadBalancer.
     * </p>
     * <p>
     * <b>NOTE:</b> In order for this call to be successful, the client must
     * have created the LoadBalancer. The client must provide the same
     * account credentials as those that were used to create the
     * LoadBalancer.
     * </p>
     * <p>
     * <b>NOTE:</b> Completion of this API does not guarantee that operation
     * has completed. Rather, it means that the request has been registered
     * and the changes will happen shortly.
     * </p>
     *
     * @param registerInstancesWithLoadBalancerRequest Container for the
     *           necessary parameters to execute the RegisterInstancesWithLoadBalancer
     *           operation on AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         RegisterInstancesWithLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<RegisterInstancesWithLoadBalancerResult> registerInstancesWithLoadBalancerAsync(
            final RegisterInstancesWithLoadBalancerRequest registerInstancesWithLoadBalancerRequest,
            final AsyncHandler<RegisterInstancesWithLoadBalancerRequest, RegisterInstancesWithLoadBalancerResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<RegisterInstancesWithLoadBalancerResult>() {
            public RegisterInstancesWithLoadBalancerResult call() throws Exception {
            	RegisterInstancesWithLoadBalancerResult result;
                try {
            		result = registerInstancesWithLoadBalancer(registerInstancesWithLoadBalancerRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(registerInstancesWithLoadBalancerRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Associates one or more security groups with your LoadBalancer in VPC.
     * The provided security group IDs will override any currently applied
     * security groups.
     * </p>
     *
     * @param applySecurityGroupsToLoadBalancerRequest Container for the
     *           necessary parameters to execute the ApplySecurityGroupsToLoadBalancer
     *           operation on AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         ApplySecurityGroupsToLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ApplySecurityGroupsToLoadBalancerResult> applySecurityGroupsToLoadBalancerAsync(final ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ApplySecurityGroupsToLoadBalancerResult>() {
            public ApplySecurityGroupsToLoadBalancerResult call() throws Exception {
                return applySecurityGroupsToLoadBalancer(applySecurityGroupsToLoadBalancerRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Associates one or more security groups with your LoadBalancer in VPC.
     * The provided security group IDs will override any currently applied
     * security groups.
     * </p>
     *
     * @param applySecurityGroupsToLoadBalancerRequest Container for the
     *           necessary parameters to execute the ApplySecurityGroupsToLoadBalancer
     *           operation on AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         ApplySecurityGroupsToLoadBalancer service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<ApplySecurityGroupsToLoadBalancerResult> applySecurityGroupsToLoadBalancerAsync(
            final ApplySecurityGroupsToLoadBalancerRequest applySecurityGroupsToLoadBalancerRequest,
            final AsyncHandler<ApplySecurityGroupsToLoadBalancerRequest, ApplySecurityGroupsToLoadBalancerResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<ApplySecurityGroupsToLoadBalancerResult>() {
            public ApplySecurityGroupsToLoadBalancerResult call() throws Exception {
            	ApplySecurityGroupsToLoadBalancerResult result;
                try {
            		result = applySecurityGroupsToLoadBalancer(applySecurityGroupsToLoadBalancerRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(applySecurityGroupsToLoadBalancerRequest, result);
               	return result;
		    }
		});
    }
    
    /**
     * <p>
     * Returns detailed configuration information for the specified
     * LoadBalancers. If no LoadBalancers are specified, the operation
     * returns configuration information for all LoadBalancers created by the
     * caller.
     * </p>
     * <p>
     * <b>NOTE:</b> The client must have created the specified input
     * LoadBalancers in order to retrieve this information; the client must
     * provide the same account credentials as those that were used to create
     * the LoadBalancer.
     * </p>
     *
     * @param describeLoadBalancersRequest Container for the necessary
     *           parameters to execute the DescribeLoadBalancers operation on
     *           AmazonElasticLoadBalancing.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLoadBalancers service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLoadBalancersResult> describeLoadBalancersAsync(final DescribeLoadBalancersRequest describeLoadBalancersRequest) 
            throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLoadBalancersResult>() {
            public DescribeLoadBalancersResult call() throws Exception {
                return describeLoadBalancers(describeLoadBalancersRequest);
		    }
		});
    }

    
    /**
     * <p>
     * Returns detailed configuration information for the specified
     * LoadBalancers. If no LoadBalancers are specified, the operation
     * returns configuration information for all LoadBalancers created by the
     * caller.
     * </p>
     * <p>
     * <b>NOTE:</b> The client must have created the specified input
     * LoadBalancers in order to retrieve this information; the client must
     * provide the same account credentials as those that were used to create
     * the LoadBalancer.
     * </p>
     *
     * @param describeLoadBalancersRequest Container for the necessary
     *           parameters to execute the DescribeLoadBalancers operation on
     *           AmazonElasticLoadBalancing.
     * @param asyncHandler Asynchronous callback handler for events in the
     *           life-cycle of the request. Users could provide the implementation of
     *           the four callback methods in this interface to process the operation
     *           result or handle the exception.
     * 
     * @return A Java Future object containing the response from the
     *         DescribeLoadBalancers service method, as returned by
     *         AmazonElasticLoadBalancing.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonElasticLoadBalancing indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public Future<DescribeLoadBalancersResult> describeLoadBalancersAsync(
            final DescribeLoadBalancersRequest describeLoadBalancersRequest,
            final AsyncHandler<DescribeLoadBalancersRequest, DescribeLoadBalancersResult> asyncHandler)
                    throws AmazonServiceException, AmazonClientException {
        return executorService.submit(new Callable<DescribeLoadBalancersResult>() {
            public DescribeLoadBalancersResult call() throws Exception {
            	DescribeLoadBalancersResult result;
                try {
            		result = describeLoadBalancers(describeLoadBalancersRequest);
            	} catch (Exception ex) {
            	    asyncHandler.onError(ex);
    				throw ex;
            	}
            	asyncHandler.onSuccess(describeLoadBalancersRequest, result);
               	return result;
		    }
		});
    }
    
}
        
