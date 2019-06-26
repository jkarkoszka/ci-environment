import hudson.security.*
import jenkins.model.*

def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin","password")
instance.setSecurityRealm(hudsonRealm)

def strategy = new GlobalMatrixAuthorizationStrategy()
strategy.add(Jenkins.ADMINISTER, "admin")
instance.setAuthorizationStrategy(strategy)

instance.save()

