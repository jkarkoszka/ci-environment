/*multibranchPipelineJob('spring-boot-example') {
    branchSources {
        git {
            remote('git@github.com:jkarkoszka/spring-boot-example.git')
            credentialsId('github-access-token')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(5)
        }
    }
    triggers {
        periodic(1440)
    }
}*/
