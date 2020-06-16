node {
  stage ('Checkout') {
    svn 'https://svn.mycorp/trunk/'
    stage 'Build'
    sh 'make all'
    stage 'Test'
    sh 'make test'
  }
}