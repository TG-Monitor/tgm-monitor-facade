package ai.quantumsense.tgmonitor.monitorfacade;

import ai.quantumsense.tgmonitor.entities.Emails;
import ai.quantumsense.tgmonitor.entities.Patterns;
import ai.quantumsense.tgmonitor.entities.Peers;
import ai.quantumsense.tgmonitor.monitor.LoginCodePrompt;
import ai.quantumsense.tgmonitor.monitor.Monitor;
import ai.quantumsense.tgmonitor.servicelocator.ServiceLocator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MonitorFacadeImpl implements MonitorFacade {

    private ServiceLocator<Monitor> monitorLocator;
    private ServiceLocator<Peers> peersLocator;
    private ServiceLocator<Patterns> patternsLocator;
    private ServiceLocator<Emails> emailsLocator;
    private ServiceLocator<LoginCodePrompt> loginCodePromptLocator;

    public MonitorFacadeImpl(ServiceLocator<Monitor> monitorLocator,
                             ServiceLocator<Peers> peersLocator,
                             ServiceLocator<Patterns> patternsLocator,
                             ServiceLocator<Emails> emailsLocator,
                             ServiceLocator<LoginCodePrompt> loginCodePromptLocator) {
        this.monitorLocator = monitorLocator;
        this.peersLocator = peersLocator;
        this.patternsLocator = patternsLocator;
        this.emailsLocator = emailsLocator;
        this.loginCodePromptLocator = loginCodePromptLocator;
    }

    @Override
    public void login(String phoneNumber) {
        monitorLocator.getService().login(phoneNumber);
    }

    @Override
    public void logout() {
        monitorLocator.getService().logout();
    }

    @Override
    public boolean isLoggedIn() {
        return monitorLocator.getService().isLoggedIn();
    }

    @Override
    public void start() {
        monitorLocator.getService().start();
    }

    @Override
    public void stop() {
        monitorLocator.getService().stop();
    }

    @Override
    public boolean isRunning() {
        return monitorLocator.getService().isRunning();
    }

    @Override
    public String getPhoneNumber() {
        return monitorLocator.getService().getPhoneNumber();
    }

    @Override
    public Set<String> getPeers() {
        return peersLocator.getService().getPeers();
    }

    @Override
    public void setPeers(List<String> peers) {
        peersLocator.getService().setPeers(new HashSet<>(peers));
    }

    @Override
    public void addPeer(String peer) {
        peersLocator.getService().addPeer(peer);
    }

    @Override
    public void addPeers(Set<String> peers) {
        peersLocator.getService().addPeers(peers);
    }

    @Override
    public void removePeer(String peer) {
        peersLocator.getService().removePeer(peer);
    }

    @Override
    public void removePeers(Set<String> peers) {
        peersLocator.getService().removePeers(peers);
    }

    @Override
    public Set<String> getPatterns() {
        return patternsLocator.getService().getPatterns();
    }

    @Override
    public void setPatterns(Set<String> patterns) {
        patternsLocator.getService().setPatterns(patterns);
    }

    @Override
    public void addPattern(String pattern) {
        patternsLocator.getService().addPattern(pattern);
    }

    @Override
    public void addPatterns(Set<String> patterns) {
        patternsLocator.getService().addPatterns(patterns);
    }

    @Override
    public void removePattern(String pattern) {
        patternsLocator.getService().removePattern(pattern);
    }

    @Override
    public void removePatterns(Set<String> patterns) {
        patternsLocator.getService().addPatterns(patterns);
    }

    @Override
    public Set<String> getEmails() {
        return emailsLocator.getService().getEmails();
    }

    @Override
    public void setEmails(Set<String> emails) {
        emailsLocator.getService().setEmails(emails);
    }

    @Override
    public void addEmail(String email) {
        emailsLocator.getService().addEmail(email);
    }

    @Override
    public void addEmails(Set<String> emails) {
        emailsLocator.getService().setEmails(emails);
    }

    @Override
    public void removeEmail(String email) {
        emailsLocator.getService().removeEmail(email);
    }

    @Override
    public void removeEmails(Set<String> emails) {
        emailsLocator.getService().removeEmails(emails);
    }

    @Override
    public void registerLoginCodePrompt(LoginCodePromptFacade loginCodePrompt) {
        loginCodePromptLocator.registerService(loginCodePrompt);
    }

}
