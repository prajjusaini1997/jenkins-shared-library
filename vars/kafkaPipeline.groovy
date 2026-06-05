def call(Map config = [:]) {

    node('ubuntu-agent') {

        echo "===== Kafka Shared Library Started ====="

        stage('Clone Repo') {
            git url: config.repoUrl, branch: config.branch ?: 'main'
        }

        stage('Approval') {
            input message: 'Approve Kafka Deployment?'
        }

        stage('Playbook Execution') {
            sh '''
                echo "Running Ansible Playbook..."
            '''
        }

        stage('Notification') {
            echo "Sending Notification..."
        }

        echo "===== Kafka Shared Library Completed ====="
    }
}
