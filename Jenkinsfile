node {
  stage ('checkout') {
    git 'https://github.com/ramasamy0611/expmgr-backend/'
    stage 'build'
    sh 'mvn clean install'
    stage 'mvn'
    sh 'make test'
  }
}