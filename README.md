# Mitigation for SECURITY-218

Until a proper fix is developed, [this script](cli-shutdown.groovy) can be used to shut down CLI subsystem of Jenkins to protect Jenkins from a known vulnerability.

When run from the Groovy script console (`/script`), this shuts down CLI subsystem of a running Jenkins without needing a restart.

When placed in `$JENKINS_HOME/init.groovy.d/cli-shutdown.groovy` it makes sure the protection stays in place after master restart.

To see if the mitigation is successfully applied, try running `java -jar cli.jar -s $JENKINS_URL` with [cli.jar](http://repo.jenkins-ci.org/releases/org/jenkins-ci/main/cli/1.636/cli-1.636-jar-with-dependencies.jar) and make sure you get `EOFException` like the following:

```
java.io.EOFException
	at java.io.DataInputStream.readFully(DataInputStream.java:197)
	at java.io.DataInputStream.readUTF(DataInputStream.java:609)
	at java.io.DataInputStream.readUTF(DataInputStream.java:564)
	at hudson.cli.CLI.connectViaCliPort(CLI.java:232)
	at hudson.cli.CLI.<init>(CLI.java:128)
	at hudson.cli.CLIConnectionFactory.connect(CLIConnectionFactory.java:72)
	at hudson.cli.CLI._main(CLI.java:479)
	at hudson.cli.CLI.main(CLI.java:390)
	Suppressed: java.io.IOException: https://ci.jenkins-ci.org/cli doesn't look like Jenkins
		at hudson.cli.FullDuplexHttpStream.<init>(FullDuplexHttpStream.java:81)
		at hudson.cli.CLI.connectViaHttp(CLI.java:158)
		at hudson.cli.CLI.<init>(CLI.java:132)
		... 3 more
```

# FAQ
### How do I interpret the output from this script?
It doesn't mean anything useful. So please ignore the output. See above for how to verify that the mitigation took place. To be safe, please also perform the verification again if you restart Jenkins.

### Does this affect the REST API?
No.
