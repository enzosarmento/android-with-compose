package com.example.thirtydays

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydays.model.DayTask
import com.example.thirtydays.model.DayTaskRepository
import com.example.thirtydays.ui.theme.ThirtyDaysTheme

@Composable
fun DayTaskList(tasks: List<DayTask>, modifier: Modifier = Modifier) {
    var expandedDayId by remember { mutableIntStateOf(-1) }
    LazyColumn(
        modifier = modifier
    ) {
        items(tasks) { dayTask ->
            DayTaskCard(
                showDescription = expandedDayId == dayTask.day,
                onClick = { expandedDayId = if (expandedDayId == dayTask.day) -1 else dayTask.day },
                dayTask = dayTask,
                modifier = Modifier.padding(dimensionResource(R.dimen.medium_padding))
            )
        }
    }
}

@Composable
fun  DayTaskCard(showDescription: Boolean, onClick: () -> Unit, dayTask: DayTask, modifier: Modifier = Modifier) {

    Card(
        shape = RoundedCornerShape(dimensionResource(R.dimen.small_padding)),
        modifier = modifier.clickable {
            onClick()
        }
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(dimensionResource(R.dimen.medium_padding))
                .fillMaxWidth().animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Text(
                text = "Day ${dayTask.day}",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(dayTask.title),
                style = MaterialTheme.typography.displayMedium
            )
            Image(
                painter = painterResource(dayTask.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensionResource(R.dimen.small_padding),
                        bottom = dimensionResource(R.dimen.small_padding)
                    )
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.small_padding))),
                contentScale = ContentScale.Crop
            )
            if (showDescription) {
                Text(
                    text = stringResource(dayTask.description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview
@Composable
fun DayTaskPreview() {
    ThirtyDaysTheme(darkTheme = false) {
        DayTaskList(DayTaskRepository.tasks)
    }
}

@Preview
@Composable
fun DayTaskDarkPreview() {
    ThirtyDaysTheme(darkTheme = true) {
        DayTaskList(DayTaskRepository.tasks)
    }
}