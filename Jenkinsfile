node {
  stage ('checkout') {
    svn 'https://svn.mycorp/trunk/'
    stage 'build'
    sh 'make all'
    stage 'Test'
    sh 'make test'
  }
}