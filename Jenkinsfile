pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        DOCKER_USER = 'kp0705'
        IMAGE_NAME = 'scientific-calculator'
        TAG = 'latest'
        IMAGE = "${DOCKER_USER}/${IMAGE_NAME}:${TAG}"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/kp-0705/scientific-calculator.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE} ."
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'docker-creds',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS')]) {

                    sh '''
                        echo "$PASS" | docker login -u "$USER" --password-stdin
                        docker push ${IMAGE}
                        docker logout
                    '''
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i ansible/inventory.ini ansible/deploy.yml'
            }
        }
    }

    post {
        success {
            mail(
                to: 'kpbhai0705@gmail.com',
                subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build Successful!\n\nJob: ${env.JOB_NAME}\nBuild: ${env.BUILD_NUMBER}\nURL: ${env.BUILD_URL}"
            )
        }

        failure {
            mail(
                to: 'kpbhai0705@gmail.com',
                subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build Failed!\nCheck: ${env.BUILD_URL}"
            )
        }
    }
}
