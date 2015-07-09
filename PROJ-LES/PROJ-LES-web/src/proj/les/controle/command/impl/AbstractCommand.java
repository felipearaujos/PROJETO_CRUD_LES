
package proj.les.controle.command.impl;

import proj.les.controle.command.ICommand;
import proj.les.core.IFachada;
import proj.les.core.impl.controle.Fachada;



public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();

}
