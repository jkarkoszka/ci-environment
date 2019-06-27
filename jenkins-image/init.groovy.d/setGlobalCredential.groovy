import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.plugins.credentials.impl.*
import hudson.plugins.sshslaves.*
import jenkins.model.*
import org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl
import hudson.util.Secret

domain = Domain.global()
store = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].getStore()

usernameAndPassword = new UsernamePasswordCredentialsImpl(
        CredentialsScope.GLOBAL,
        "gitlab-access-token",
        "Jenkins - Gitlab Access Token",
        "PLACEHOLDER_GITLAB_USERNAME",
        "PLACEHOLDER_GITLAB_PERSONAL_ACCESS_TOKEN"
)

docker = new UsernamePasswordCredentialsImpl(
        CredentialsScope.GLOBAL,
        "registry-ci-yourdomain-com-credentials",
        "Docker Private Registry",
        "PLACEHOLDER_PRIVATE_DOCKER_REGISTRY_USERNAME",
        "PLACEHOLDER_PRIVATE_DOCKER_REGISTRY_PASSWORD"
)

kubernetes = new StringCredentialsImpl(
        CredentialsScope.GLOBAL,
        "kubernetes-ci-yourdomain-com-credentials",
        "Kubernetes Cluster",
        Secret.fromString("PLACEHOLDER_KUBERNETES_ADMIN_TOKEN"))

store.addCredentials(domain, usernameAndPassword)
store.addCredentials(domain, docker)
store.addCredentials(domain, kubernetes)
