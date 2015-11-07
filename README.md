# Mitigation for SECURITY-218

When run from the Groovy script console (`/script`), this shuts down CLI subsystem of Jenkins.

When placed in `$JENKINS_HOME/init.groovy.d/cli-shutdown.groovy` it makes sure the protection stays in place after master restart.
