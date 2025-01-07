package Practica1Prestamos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Practica1Prestamos.beans.Clientes;
import Practica1Prestamos.beans.Prestamo;
import Practica1Prestamos.models.ClienteModelo;
import Practica1Prestamos.models.PrestamoModelo;

/**
 * Servlet implementation class ClientesController
 */
public class ClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteModelo modelo = new ClienteModelo();
	PrestamoModelo modeloP = new PrestamoModelo();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			if(request.getParameter("op")==null) {
				listar(request, response);
				return;
			}
			String operacion = request.getParameter("op");
			switch (operacion) {
			case "listar":
				listar(request, response);
				break;
			case "nuevo":
				request.getRequestDispatcher("/cliente/nuevoCliente.jsp").forward(request, response);
				break;
			case "insertar":
				insertar(request, response);
				break;
			case "prestamos":
				listarPrestamos(request, response);
				break;
			}
		} catch (Exception e) {
			System.out.println("Error en la funcion principál:" +e.getMessage());
		}
    }
    private boolean validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	boolean res = false;
    	List<String> ListError = new ArrayList<>();
    	try {
			if(request.getParameter("nombre").equals("")) {
				res = true;
				ListError.add("Ingrese el nombre del cliente");
			}
			if(request.getParameter("apellido").equals("")) {
				res = true;
				ListError.add("Ingrese la apellido del cliente");
			}
			if(request.getParameter("dni").equals("")) {
				res = true;
				ListError.add("Ingrese el dni del cliente");
			}
			if(request.getParameter("fechaNac").equals("")) {
				res = true;
				ListError.add("Ingrese el fechaNac del cliente");
			}
			if(request.getParameter("direccion").equals("")) {
				res = true;
				ListError.add("Ingrese el direccion del cliente");
			}
			request.setAttribute("respuesta", res);
			request.setAttribute("listaError", ListError);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
    	return res;
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			request.setAttribute("listaClientes", modelo.listarClientes());
			Iterator<Clientes> it = modelo.listarClientes().iterator();
			while(it.hasNext()) {
				Clientes c = it.next();
				System.out.println(c.getIdCli()+" "+c.getNombres());
			}
			request.getRequestDispatcher("/cliente/listaCliente.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    public void listarPrestamos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		String idClie = request.getParameter("id");
			request.setAttribute("listaPrestamos", modeloP.listaPrestamos(Integer.parseInt(idClie)));
			Iterator<Prestamo> it = modeloP.listaPrestamos(Integer.parseInt(idClie)).iterator();
			while(it.hasNext()) {
				Prestamo pres = it.next();
				System.out.println(pres.getIdprest()+" "+pres.getMontPre());
			}
			request.getRequestDispatcher("/cliente/listaPrestamos.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    public void insertar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		
    			Clientes cliente = new Clientes();
    			cliente.setNombres(request.getParameter("nombre"));
    			cliente.setApellidos(request.getParameter("apellido"));
    			cliente.setDni(request.getParameter("dni"));
    			cliente.setFechNaci(Date.valueOf(request.getParameter("fechaNac")));
    			cliente.setDireccion(request.getParameter("direccion"));
    			if(modelo.insertar(cliente)>0) {
    				request.getSession().setAttribute("exito", "Cliente registrado correctamente");
    				response.sendRedirect(request.getContextPath()+"/ClientesController?op=listar");
    			} else {
    				request.getSession().setAttribute("Fracaso", "Prercio no registrado ya que hay otro autor con ese codigo ");
    				response.sendRedirect(request.getContextPath()+"/ClientesController?op=listar");
    			}
    		
			
		} catch (Exception e) {
			System.out.println("Error al insertar desde el controlador "+e.getMessage());
		}	
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
