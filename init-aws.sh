#!/usr/bin/env bash
awslocal --endpoint-url=http://localhost:4566 sqs create-queue --queue-name EventQueue --region us-east-1 --attributes VisibilityTimeout=180
awslocal s3 mb s3://my-bucket