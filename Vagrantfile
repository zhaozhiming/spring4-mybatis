# -*- mode: ruby -*-
# vi: set ft=ruby :


VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "pebms"

  config.vm.define "pebms" do |dev|
      dev.vm.hostname = "dev-env"
      dev.vm.network :private_network, ip: "192.168.36.10"
      dev.vm.provider :virtualbox do |vb|
        vb.memory = 512
        vb.cpus = 1
      end
  end
 end
