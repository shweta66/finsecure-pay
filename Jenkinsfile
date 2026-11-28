pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checkout successful'
            }
        }

        stage('Build') {
            steps {
                echo 'Build successful'
            }
        }

        stage('Test') {
            steps {
                echo 'Tests successful'
            }
        }

        stage('Package') {
            steps {
                echo 'Package successful'
            }
        }

        stage('Security Checks') {
            steps {
                echo 'Security checks completed'
            }
        }

        stage('Container Build') {
            steps {
                echo 'Docker build completed'
            }
        }

        stage('Push') {
            steps {
                echo 'Docker push completed'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Kubernetes deployment completed'
            }
        }
    }
}
