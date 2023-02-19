pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('BuildDockerimage'){
            steps{
            sh'./gradlewdocker'
             }
        }

        stage('PushDockerimage'){
            environment{
            DOCKER_HUB_LOGIN=credentials('docker-hub')
        }
            steps{
                sh'dockerloginusername=$DOCKER_HUB_LOGIN_USR--password='$DOCKER_HUB_LOGIN_PSW'
                sh'./gradlewdockerPush'
            }
        }

    }
}
