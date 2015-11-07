import jenkins.*;
import jenkins.model.*;

def p = AgentProtocol.all()
p.each { x ->
  if (x.name.contains("CLI")) p.remove(x)
}

def j = Jenkins.instance;
j.actions.each { x -> if (x.class.name.contains("CLIAction")) j.actions.remove(x) }
