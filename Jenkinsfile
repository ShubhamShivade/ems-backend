pipeline {
    agent any

    tools {
        maven 'Maven_3.8.5' // Use your Maven name from Jenkins (Global Tool Config)
        jdk 'JDK_17'        // Use your JDK name from Jenkins
    }

    environment {
        BRANCH_NAME = "${env.BRANCH_NAME}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ShubhamShivade/ems-backend.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Deploy (Optional)') {
            steps {
                echo "Deploy step goes here. (Docker run, SCP, etc.)"
                // sh './scripts/deploy.sh' or Docker commands
            }
        }
    }

    post {
        success {
            echo '✅ Build completed successfully!'
        }
        failure {
            echo '❌ Build failed!'
        }
    }
}
