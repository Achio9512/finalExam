import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CrudsExamenSharedModule } from 'app/shared/shared.module';
import { LeadershipComponent } from './leadership.component';
import { LeadershipDetailComponent } from './leadership-detail.component';
import { LeadershipUpdateComponent } from './leadership-update.component';
import { LeadershipDeleteDialogComponent } from './leadership-delete-dialog.component';
import { leadershipRoute } from './leadership.route';

@NgModule({
  imports: [CrudsExamenSharedModule, RouterModule.forChild(leadershipRoute)],
  declarations: [LeadershipComponent, LeadershipDetailComponent, LeadershipUpdateComponent, LeadershipDeleteDialogComponent],
  entryComponents: [LeadershipDeleteDialogComponent],
})
export class CrudsExamenLeadershipModule {}
