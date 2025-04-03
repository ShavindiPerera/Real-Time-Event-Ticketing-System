import { Component , Inject} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ConfigurationService } from '../../configuration.service';
import { SimulationComponent } from '../simulation/simulation.component';

@Component({
  selector: 'app-configuration',
  imports: [FormsModule,SimulationComponent],
  templateUrl: './configuration.component.html',
  styleUrl: './configuration.component.css'
})
export class ConfigurationComponent {
  config = {
    id: null,
    totalTickets: null,
    ticketReleaseRate: null,
    customerRetrievalRate: null,
    maxTicketCapacity: null
  };

  constructor(@Inject(ConfigurationService) private configurationService: ConfigurationService) {}

  
  async saveConfig() {
    try {
      const result = await this.configurationService.addConfiguration(this.config);
      this.config.id = result.id;
      console.log('Configuration Saved:', this.config);


      // You can perform additional actions after successful submission
    } catch (error) {
      console.error('Failed to save configuration:', error);
    }
  }

  resetConfig() {

    console.log('Configuration Saved:', this.config);
    
  }

 
}
