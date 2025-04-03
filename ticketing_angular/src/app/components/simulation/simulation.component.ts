import { Component, Input } from '@angular/core';
import { SimulationService } from '../../simulation.service';
import axios from 'axios';


@Component({
  selector: 'app-simulation',
  imports: [],
  templateUrl: './simulation.component.html',
  styleUrl: './simulation.component.css'
})


export class SimulationComponent {
 
  @Input() config: any; // This assumes you're passing the config from parent

  constructor(private simulationService: SimulationService) {}

  startSimulation() {
    this.simulationService.startSimulation()
      .then(response => {
        console.log("Simulation started:", response);
      })
      .catch(error => {
        console.error("Failed to start simulation:", error);
      });
  }
}

