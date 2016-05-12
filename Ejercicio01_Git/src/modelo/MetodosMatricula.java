/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Controlador_FRM_Matricula;
import java.util.ArrayList;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;

/**
 *
 * @author tecnologiamultimedia
 */
public class MetodosMatricula {
    
    private ArrayList <Matricula> arrayMatricula;
    String arregloInformacionConsultada[]=new String[2];
    Controlador_FRM_Matricula controlador;
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    
    public MetodosMatricula(MetodosEstudiantes metodosEstudiantes,MetodosCursos metodosCursos,Controlador_FRM_Matricula controlador)
    {
        arrayMatricula=new ArrayList <Matricula>();
        this.metodosCursos=metodosCursos;
        this.metodosEstudiantes=metodosEstudiantes;
        this.controlador=controlador;
    }
    public void agregarMatricula(String informacion[])
    {
        Matricula temporal=new Matricula(informacion[0], informacion[1], informacion[2]);
        arrayMatricula.add(temporal);    
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            System.out.println(arrayMatricula.get(contador).getInformacion());
        }
    }
    public boolean consultarMatricula(String codigo)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(codigo))
            {
                arregloInformacionConsultada[0]=arrayMatricula.get(contador).getCedula();
                arregloInformacionConsultada[1]=arrayMatricula.get(contador).getSigla();
                existe=true;
            }
            
        }
        return existe;
    }
    public void modificarMatricula(String arreglo[])
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(arreglo[0]))
            {
                arrayMatricula.get(contador).setCedula(arreglo[1]);
                arrayMatricula.get(contador).setSigla(arreglo[2]);
            }
        }
    }
    public void eliminarMatricula(String arreglo[])
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(arreglo[0]))
            {
                arrayMatricula.remove(contador);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    } 
    public String devolverCodigo()
    {
        String codigo= "0000";
        if(arrayMatricula.size()==0)
        {
            codigo+=1;
        }
        else
        {
            int numero=Integer.parseInt(arrayMatricula.get(arrayMatricula.size()-1).getCodigo());
            numero++;
            codigo="0000"+numero;
        }
        codigo=codigo.substring(codigo.length()-5, codigo.length());
        return codigo; 
    }
    
    
    
    
    
    
    
}
