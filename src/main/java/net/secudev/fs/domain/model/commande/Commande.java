package net.secudev.fs.domain.model.commande;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

@Entity
public class Commande {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String codeCommande = UUID.randomUUID().toString();
	
	private LocalDateTime dateCommande = LocalDateTime.now();
	
	private boolean payee=false;
	private boolean enTraitement=false;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name = "commande_id", nullable = true)
	private Set<DetailCommande> detail = new HashSet<DetailCommande>();
	
	@Min(0)
	private float total;
	
	
	public Commande()
	{}
	
	private void calculerTotal()
	{
		this.total=0;
		for(DetailCommande dc : detail)
		{
			total+= dc.getSousTotal();
		}
	}
	
	public void viderDetails()
	{
		this.detail.clear();
		calculerTotal();
	}
	
	public void ajouterDetail(DetailCommande detailCommande)
	{
		this.detail.add(detailCommande);
		calculerTotal();
	}
	
	public void supprimerDetail(DetailCommande detailCommande)
	{
		this.detail.remove(detailCommande);
		calculerTotal();
	}

	public boolean isPayee() {
		return payee;
	}

	public void setPayee(boolean payee) {
		this.payee = payee;
	}

	public boolean isEnTraitement() {
		return enTraitement;
	}

	public void setEnTraitement(boolean enTraitement) {
		this.enTraitement = enTraitement;
	}

	public long getId() {
		return id;
	}

	public String getCodeCommande() {
		return codeCommande;
	}

	public LocalDateTime getDateCommande() {
		return dateCommande;
	}

	public Set<DetailCommande> getDetail() {
		return detail;
	}

	public float getTotal() {
		return total;
	}


}
