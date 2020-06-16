node {
  stage ('checkout') {
    git 'https://github.com/ramasamy0611/expmgr-backend/master'
    stage 'build'
    sh 'make all'
    stage 'Test'
    sh 'make test'
  }
}