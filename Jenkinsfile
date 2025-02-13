pipeline {
    agent any
    stages {
        stage('Clone Repository') {
            steps {
                // Git clone repository
                git 'https://github.com/gowthamprostack/Dockerone.git'
            }
        }
        stage('Build') {
            steps {
                // Run your build commands here (e.g., Maven, Gradle)
                bat 'mvn clean install'  // For Windows
            }
        }
        stage('Publish JSON Report') {
            steps {
                // Archive the JSON reports from target/jsonReports
                archiveArtifacts artifacts: "$WORKSPACE/Dockermaven/target/jsonReports/*.json", allowEmptyArchive: true
            }
        }
    }
    post {
        always {
            // Additional actions (if necessary) after build
        }
    }
}