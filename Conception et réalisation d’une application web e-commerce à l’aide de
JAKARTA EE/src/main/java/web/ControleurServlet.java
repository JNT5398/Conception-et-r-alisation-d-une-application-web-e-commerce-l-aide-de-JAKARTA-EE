package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dao.AdminDaoImpl;
import dao.ClientDaoImpl;
import dao.FornisseurDaoImpl;
import dao.IAdminDao;
import dao.IClientDao;
import dao.IFornisseurDao;
import dao.IProduitDao;
import dao.ProduirDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.entities.Admin;
import metier.entities.Client;
import metier.entities.Fornisseur;
import metier.entities.Produit;


public class ControleurServlet extends HttpServlet {
	private IClientDao metier;
	private IProduitDao metierP;
	private IFornisseurDao metierF;
	private IAdminDao metierA;

	@Override
	public void init() throws ServletException {
		metier = new ClientDaoImpl();
		metierP = new ProduirDaoImpl();
		metierF = new FornisseurDaoImpl();
		metierA = new AdminDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		String path=req.getServletPath();
		
		
		 HttpSession session = req.getSession(true);
		 String LoginAdmin = (String) session.getAttribute("Login");
		 String LoginClient = (String) session.getAttribute("LoginClient");

         if(path.equals("/connectionClient.do")) {
        	 String em=req.getParameter("Email_Client"),	passC=req.getParameter("PassWord_Client");
        	 
        	 if(em.equals(metier.getClientParE(em).getEmail()) && passC.equals(metier.getClientParE(em).getPassword()) ) { 
        		 session.setAttribute("LoginClient", em);
		         Client c=metier.getClientParE(em);
		         String Nom = c.getNom();
		         String Prenom = c.getPrenom();
		
		         session.setAttribute("Nom", Nom);
		         session.setAttribute("Prenom", Prenom);
		
//		///////////////////////////
		
		         List<Produit> Produits = metierP.getProduit();
		         ProduitModel model= new ProduitModel();
			     model.setProduit(Produits);
			     req.setAttribute("model", model);
		
		
		         req.getRequestDispatcher("homeClient.jsp").forward(req, resp);
	           }
            }

         if(path.equals("/*.do")) {
        	 req.getRequestDispatcher("Home.jsp").forward(req, resp);
           }
 
         if(path.equals("/connection.do")) {
        	 
        	 String lg=req.getParameter("Login"),	pass=req.getParameter("Password"); 
		
		     if(lg.equals(metierA.getAdmin(lg).getLogin()) && pass.equals(metierA.getAdmin(lg).getPassword()) ) { 
		    	 Admin A=metierA.getAdmin(lg);
			     String login = A.getLogin();
			
			     session.setAttribute("Login", login);
			
			     req.getRequestDispatcher("homeAdmin.jsp").forward(req, resp);
		       }
           }
 
 ///HOME??????
 
         if(path.equals("/Client.do")) {
        	 if(LoginClient != null) {
        		 List<Produit> Produits = metierP.getProduit();
		         ProduitModel model= new ProduitModel();
			     model.setProduit(Produits);
			     req.setAttribute("model", model);
		         req.getRequestDispatcher("homeClient.jsp").forward(req, resp);
	          }else req.getRequestDispatcher("HomeLoginClient.jsp").forward(req, resp);
	  
           }else if(path.equals("/Admin.do")) {
        	   if(LoginAdmin != null ) {
        		   req.getRequestDispatcher("homeAdmin.jsp").forward(req, resp);
	             }else req.getRequestDispatcher("LoginAdmin.jsp").forward(req, resp);
               } else if(path.equals("/CreerCompte.do")) {
            	   req.getRequestDispatcher("nvCompte.jsp").forward(req, resp);
                   }else if(path.equals("/SaveClient.do")&&(req.getMethod().equals("POST"))) {
                	    String nom = req.getParameter("Nom_Client");
						String prenom = req.getParameter("Prenom_Client");
						String adresse = req.getParameter("Adresse_Client");
						String email = req.getParameter("Email_Client");
					    long tele = Long.parseLong((req.getParameter("NumeroTele_Client")));
						String password = req.getParameter("PassWord_Client");
		
						Client c = metier.save(new Client(nom, prenom, adresse, email, tele, password));
						req.setAttribute("client",c);
						req.getRequestDispatcher("HomeLoginClient.jsp").forward(req, resp);

	                   }else if(path.equals("/chercher.do")) {
	                	    String motCle=req.getParameter("motCle");
							ProduitModel model= new ProduitModel();
							model.setMotCle(motCle);
							List<Produit> produits=metierP.produitParId("%"+motCle+"%");
							model.setProduit(produits);
							req.setAttribute("model", model);
							req.getRequestDispatcher("produitCh.jsp").forward(req, resp);
	                       }
         
 
 //////LoginClient????
 
          else if(LoginClient != null) {
        	  if(path.equals("/panier.do")) {
        		  resp.sendRedirect("valider.do");
	             }
	          else if(path.equals("/votreCompte.do")) {
	        	  
	        	  String em = (String) session.getAttribute("LoginClient");
				  Client cl = metier.getClientParE(em);
				  req.setAttribute("client", cl);
			      req.getRequestDispatcher("EditMonCompte.jsp").forward(req, resp);
			      
	                 }else if(path.equals("/UpdateClient.do")&&(req.getMethod().equals("POST"))) {
	                	 
	                	 long id = Long.parseLong(req.getParameter("Id_Client"));
						 String nom = req.getParameter("Nom_Client");
						 String prenom = req.getParameter("Prenom_Client");
						 String adresse = req.getParameter("Adresse_Client");
						 String email = req.getParameter("Email_Client");
						 long tele = Long.parseLong((req.getParameter("NumeroTele_Client")));
						 String password = req.getParameter("PassWord_Client");
							
						 Client c = new Client(nom, prenom, adresse, email, tele, password);
						 c.setId(id);
							
						 metier.update(c);
						 req.setAttribute("client",c);
						 req.getRequestDispatcher("ConfirmationMonCompte.jsp").forward(req, resp);
						 
	                  }else if(path.equals("/Edit.do")) {
	                	  Long id=Long.parseLong(req.getParameter("id"));
			              Client c= metier.getClient(id);
			              req.setAttribute("client", c);
			              req.getRequestDispatcher("EditMonCompte.jsp").forward(req, resp);

		              }else if(path.equals("/SaveClient.do")&&(req.getMethod().equals("POST"))) {
		            	  
		            	  String nom = req.getParameter("Nom_Client");
						  String prenom = req.getParameter("Prenom_Client");
						  String adresse = req.getParameter("Adresse_Client");
						  String email = req.getParameter("Email_Client");
					      long tele = Long.parseLong((req.getParameter("NumeroTele_Client")));
						  String password = req.getParameter("PassWord_Client");
						
						  Client c = metier.save(new Client(nom, prenom, adresse, email, tele, password));
						  req.setAttribute("client",c);
						  req.getRequestDispatcher("HomeLoginClient.jsp").forward(req, resp);

		               }else if(path.equals("/valider.do")) {
		            	   
		            	   String [] item =req.getParameterValues("interest");
			
						   ProduitModel model= new ProduitModel();
						   Produit p = new Produit();
						   ArrayList<Produit> produits =new ArrayList<Produit>();
						   double pr=0;
						   
						   for (String s:item ) {
							  
							   long id = Integer.parseInt(s);
						       p = metierP.getProduit(id);
						       double prix= p.getPrix();
						       pr = pr + prix;
						       model.setId(id);
						       List<Produit> produit=metierP.produitId(id);
						       produits.addAll(produit);
						       req.setAttribute("model", model);
			                  }
						   
						   session.setAttribute("prixTotal", pr);
			               model.setProduit(produits);
			
		                   req.getRequestDispatcher("panier.jsp").forward(req, resp);

		                  }else if(path.equals("/Deconnection.do")) {
		                	  
		                	  session.invalidate();
		                      req.getRequestDispatcher("Home.jsp").forward(req, resp);
		
	                      }else if(path.equals("/EditClient.do")) {
	                    	  
	                    	  Long id=Long.parseLong(req.getParameter("id"));
			                  Client c= metier.getClient(id);
			                  req.setAttribute("client", c);
			                  req.getRequestDispatcher("EditClient.jsp").forward(req, resp);
			                  
	                      }else {
	                    	  
	                    	  List<Produit> Produits = metierP.getProduit();
		                      ProduitModel model= new ProduitModel();
			                  model.setProduit(Produits);
			                  req.setAttribute("model", model);
		                      req.getRequestDispatcher("homeClient.jsp");
		                     } 
                }
 
 ///LoineAdmin???????
 
                else if(LoginAdmin != null){
                
                	if(path.equals("/produit.do")) {
                		req.getRequestDispatcher("produit.jsp").forward(req, resp);
		               }else if(path.equals("/client.do")) {
		            	   req.getRequestDispatcher("client.jsp").forward(req, resp);
		                  }else if(path.equals("/fornisseur.do")) {
		                	  req.getRequestDispatcher("fornisseur.jsp").forward(req, resp);
		                     }
		
     //		FORNISSEUR
		
		                     else if(path.equals("/chercherF.do")) {
		                    	 
		                    	 String motCle=req.getParameter("motCle");
			
			                     FornisseurModel model= new FornisseurModel();
			                     ProduitModel model1= new ProduitModel();
			
			                     model.setMotCle(motCle);
			                     List<Fornisseur> fornisseurs=metierF.fornisseurParId(motCle);
			                     model.setFornisseur(fornisseurs);
			
			                     req.setAttribute("model", model);
			
			                     Fornisseur f = metierF.fornisseurParS(motCle);
			
			                     int id = f.getId_Fornisseur();
			
		                         List<Produit> Produits = metierP.produitFornisseurParId(id);
		
		                         model1.setProduit(Produits);
			                     req.setAttribute("model1", model1);
			
			                     req.getRequestDispatcher("fornisseur.jsp").forward(req, resp);
			                     
		                     }else if(path.equals("/SaisieF.do")) {
		                    	 
		                    	 req.setAttribute("fornisseur", new Fornisseur());
		                         req.getRequestDispatcher("SaisieF.jsp").forward(req, resp);
		                         
		                        }else if(path.equals("/SaveFornisseur.do")&&(req.getMethod().equals("POST"))) {
		                        	
		                        	String nom = req.getParameter("Nom_Fornisseur");
			                        int tele = Integer.parseInt((req.getParameter("NumeroTele_Fornisseur")));
			                        String adresse = req.getParameter("Adresse_Fornisseur");
			
			
		                            Fornisseur f = metierF.save(new Fornisseur(nom, tele, adresse));
		    
			                        req.setAttribute("fornisseur",f);
			                        req.getRequestDispatcher("Confirmation3.jsp").forward(req, resp);
			                        
		                        }else if(path.equals("/SupprimerF.do")) {
		                        	
		                        	int id=Integer.parseInt(req.getParameter("id"));
			                        metierF.deleteFornisseur(id);
			                        resp.sendRedirect("fornisseur.do");
			                        
			                       }else if(path.equals("/EditF.do")) {
			                    	   
			                    	   int id=Integer.parseInt(req.getParameter("id"));
			                           Fornisseur f= metierF.getFornisseur(id);
			                           req.setAttribute("fornisseur", f);
			                           req.getRequestDispatcher("EditFornisseur.jsp").forward(req, resp);
			                           
		                           }else if(path.equals("/UpdateFornisseur.do")&&(req.getMethod().equals("POST"))) {
		                        	   
		                        	   int id = Integer.parseInt(req.getParameter("Id_Fornisseur"));
			                           String nom = req.getParameter("Nom_Fornisseur");
			                           int tele = Integer.parseInt((req.getParameter("NumeroTele_Fornisseur")));
			                           String adresse = req.getParameter("Adresse_Fornisseur");
			
			                           Fornisseur f=new Fornisseur(nom, tele, adresse);
			                           f.setId_Fornisseur(id);
			
			                           metierF.update(f);
			
			                           req.setAttribute("fornisseur",f);
			                           req.getRequestDispatcher("Confirmation3.jsp").forward(req, resp);
			                       }else if(path.equals("/SupprimerPf.do")) {
			                    	   Long id=Long.parseLong(req.getParameter("id"));
			                           metierP.deleteProduit(id);
			                           resp.sendRedirect("fornisseur.do");
		                              }
		
		
    //		PRODUIT
		
									else if(path.equals("/chercherP.do")) {
										
										String motCle=req.getParameter("motCle");
										ProduitModel model= new ProduitModel();
										model.setMotCle(motCle);
										List<Produit> produits=metierP.produitParId("%"+motCle+"%");
										model.setProduit(produits);
										req.setAttribute("model", model);
										req.getRequestDispatcher("produit.jsp").forward(req, resp);
									}else if(path.equals("/SaisieP.do")) {
										req.setAttribute("produit", new Produit());
										req.getRequestDispatcher("SaisieP.jsp").forward(req, resp);
									}else if(path.equals("/SaveProduit.do")&&(req.getMethod().equals("POST"))) {
										String nom = req.getParameter("Nom_Produit");
										double prix = Double.parseDouble(req.getParameter("Prix_Produit")) ;
										int quantite =Integer.parseInt(req.getParameter("Quantite_Produit")) ;
											
										String img = req.getParameter("Image_Produit");	
											
										int id_Fornisseur = Integer.parseInt(req.getParameter("Id_Fornisseur"));
										int id_Categorie = Integer.parseInt(req.getParameter("Id_Categorie"));
											
										Produit p = metierP.save(new Produit(nom, prix, quantite, img, id_Fornisseur, id_Categorie));
											
										req.setAttribute("produit",p);
										req.getRequestDispatcher("Confirmation2.jsp").forward(req, resp);
									}else if(path.equals("/SupprimerP.do")) {
										Long id=Long.parseLong(req.getParameter("id"));
										metierP.deleteProduit(id);
										resp.sendRedirect("produit.do");
									}else if(path.equals("/EditP.do")) {
										Long id=Long.parseLong(req.getParameter("id"));
										Produit p= metierP.getProduit(id);
										req.setAttribute("produit", p);
										req.getRequestDispatcher("EditProduit.jsp").forward(req, resp);
									}else if(path.equals("/UpdateProduit.do")&&(req.getMethod().equals("POST"))) {
										long id = Long.parseLong(req.getParameter("Id_Produit"));
										String nom = req.getParameter("Nom_Produit");
										double prix = Double.parseDouble(req.getParameter("Prix_Produit")) ;
										int quantite =Integer.parseInt(req.getParameter("Quantite_Produit"));
										String img = req.getParameter("Image_Produit");				
										int id_Fornisseur = Integer.parseInt(req.getParameter("Id_Fornisseur"));
										int id_Categorie = Integer.parseInt(req.getParameter("Id_Categorie"));
											
										Produit p=new Produit(nom, prix, quantite, img, id_Fornisseur, id_Categorie);
											
										p.setId(id);
											
										metierP.update(p);
											
										req.setAttribute("produit",p);
										req.getRequestDispatcher("Confirmation2.jsp").forward(req, resp);
									}
									
							      //		CLIENT
									 
									else if(path.equals("/chercherC.do")) {
										
										long motCle=Integer.parseInt(req.getParameter("motCle"));
										ClientModel model= new ClientModel();
										model.setMotCle(motCle);
										List<Client> clients=metier.clientParId(motCle);
										model.setClient(clients);
										req.setAttribute("model", model);
										req.getRequestDispatcher("client.jsp").forward(req, resp);
									}else if(path.equals("/Saisie.do")) {
										req.setAttribute("client", new Client());
										req.getRequestDispatcher("Saisie.jsp").forward(req, resp);
									}else if(path.equals("/SaveClient.do")&&(req.getMethod().equals("POST"))) {
										String nom = req.getParameter("Nom_Client");
										String prenom = req.getParameter("Prenom_Client");
										String adresse = req.getParameter("Adresse_Client");
										String email = req.getParameter("Email_Client");
										long tele = Long.parseLong((req.getParameter("NumeroTele_Client")));
										String password = req.getParameter("PassWord_Client");
											
										Client c = metier.save(new Client(nom, prenom, adresse, email, tele, password));
										req.setAttribute("client",c);
										req.getRequestDispatcher("Confirmation.jsp").forward(req, resp);
							
									}else if(path.equals("/Supprimer.do")) {
									
										Long id=Long.parseLong(req.getParameter("id"));
										metier.deleteClient(id);
										resp.sendRedirect("client.do");
									}else if(path.equals("/Edit.do")) {
										Long id=Long.parseLong(req.getParameter("id"));
										Client c= metier.getClient(id);
										req.setAttribute("client", c);
										req.getRequestDispatcher("EditClient.jsp").forward(req, resp);
							
									}else if(path.equals("/UpdateClient.do")&&(req.getMethod().equals("POST"))) {
										long id = Long.parseLong(req.getParameter("Id_Client"));
										String nom = req.getParameter("Nom_Client");
										String prenom = req.getParameter("Prenom_Client");
										String adresse = req.getParameter("Adresse_Client");
										String email = req.getParameter("Email_Client");
										long tele = Long.parseLong((req.getParameter("NumeroTele_Client")));
										String password = req.getParameter("PassWord_Client");
											
										Client c = new Client(nom, prenom, adresse, email, tele, password);
										c.setId(id);
											
										metier.update(c);
											
										req.setAttribute("client",c);
										req.getRequestDispatcher("Confirmation.jsp").forward(req, resp);
									}else if(path.equals("/Deconnection.do")) {
										session.invalidate();
										req.getRequestDispatcher("Home.jsp").forward(req, resp);
									}else {
										req.getRequestDispatcher("homeAdmin.jsp").forward(req, resp);
									}
				}else req.getRequestDispatcher("Home.jsp").forward(req, resp);
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}