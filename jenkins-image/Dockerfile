FROM jenkins/jenkins

USER root

RUN apt-get update && \
 apt-get install -y apt-transport-https ca-certificates curl software-properties-common && \
 curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - && \
 add-apt-repository  "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable" && \
 apt-get update && \
 apt-get install -y docker-ce

RUN /usr/local/bin/install-plugins.sh chucknorris github bitbucket job-dsl groovy workflow-aggregator branch-api github-organization-folder matrix-auth ws-cleanup antisamy-markup-formatter build-timeout credentials-binding cloudbees-folder timestamper ant gradle github-branch-source pipeline-github-lib pipeline-stage-view git subversion ssh-slaves pam-auth ldap email-ext kubernetes-cli kubernetes-credentials

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY init.groovy.d/setGlobalCredential.groovy /usr/share/jenkins/ref/init.groovy.d/setGlobalCredential.groovy
COPY init.groovy.d/runDslScripts.groovy /usr/share/jenkins/ref/init.groovy.d/runDslScripts.groovy
COPY init.groovy.d/createAdmin.groovy /usr/share/jenkins/ref/init.groovy.d/createAdmin.groovy
COPY init.groovy.d/setMasterKillSwitch.groovy /usr/share/jenkins/ref/init.groovy.d/setMasterKillSwitch.groovy
COPY dsl/createJobs.groovy /usr/share/jenkins/ref/dsl/createJobs.groovy
