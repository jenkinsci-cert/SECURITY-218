# Mitigation for SECURITY-218

Until a proper fix is developed, [this script](cli-shutdown.groovy) can be used to shut down CLI subsystem of Jenkins to protect Jenkins from a known vulnerability.

When run from the Groovy script console (`/script`), this shuts down CLI subsystem of a running Jenkins without needing a restart.

When placed in `$JENKINS_HOME/init.groovy.d/cli-shutdown.groovy` it makes sure the protection stays in place after master restart.
