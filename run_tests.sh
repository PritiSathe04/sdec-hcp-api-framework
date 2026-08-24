#!/usr/bin/env bash

ENVIRONMENT=$1

mvn clean \
    -Denvironment="${ENVIRONMENT:=local}" \
    test