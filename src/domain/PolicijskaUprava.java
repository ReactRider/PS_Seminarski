/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;

/**
 *
 * @author Stefan
 */
public class PolicijskaUprava {
    private Long id;
    private String username;
    private String password;
    private String grad;
    private String opstina;
    private String adresa;

    public PolicijskaUprava(Long id, String username, String password, String grad, String opstina, String adresa) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.grad = grad;
        this.opstina = opstina;
        this.adresa = adresa;
    }

    public PolicijskaUprava(String username, String password, String grad, String opstina, String adresa) {
        this.username = username;
        this.password = password;
        this.grad = grad;
        this.opstina = opstina;
        this.adresa = adresa;
    }

    public PolicijskaUprava(Long id, String username, String password, String adresa) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.adresa = adresa;
    }
    
    public PolicijskaUprava(String username) {
        this.username = username;
    }
    
    public PolicijskaUprava(String grad, int x) {
        this.grad = grad;
    }

    public PolicijskaUprava(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public PolicijskaUprava(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PolicijskaUprava(Long id) {
        this.id = id;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username + ", " + grad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PolicijskaUprava other = (PolicijskaUprava) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.grad, other.grad)) {
            return false;
        }
        if (!Objects.equals(this.opstina, other.opstina)) {
            return false;
        }
        if (!Objects.equals(this.adresa, other.adresa)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    
    
    
    
}
